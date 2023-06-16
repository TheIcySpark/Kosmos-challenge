package kosmos.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import kosmos.challenge.model.AppointmentModel;
import kosmos.challenge.repository.AppointmentRepository;
import kosmos.challenge.repository.ConsultingRoomRepository;
import kosmos.challenge.repository.DoctorRepository;

@Controller
public class AppointmentController {
    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ConsultingRoomRepository consultingRoomRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/")
    public String showAppointments(Model model) {
        List<AppointmentModel> appointments = appointmentRepository.findAll();
        model.addAttribute("appointments", appointments);
        return "index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("appointment", new AppointmentModel());
        model.addAttribute("rooms", consultingRoomRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "appointment-form";
    }

    @PostMapping("/new")
    public String createAppointment(@ModelAttribute("appointment") @Validated AppointmentModel appointment,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("rooms", consultingRoomRepository.findAll());
            model.addAttribute("doctors", doctorRepository.findAll());
            return "appointment-form";
        }
        appointmentRepository.save(appointment);
        return "redirect:/";
    }

    @GetMapping("/appointments/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        AppointmentModel appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment ID: " + id));
        model.addAttribute("appointment", appointment);
        model.addAttribute("rooms", consultingRoomRepository.findAll());
        model.addAttribute("doctors", doctorRepository.findAll());
        return "appointment-form";
    }

    @PostMapping("/appointments/{id}")
    public String editAppointment(@PathVariable("id") Long id,
            @ModelAttribute("appointment") @Validated AppointmentModel appointment, BindingResult result) {
        if (result.hasErrors()) {
            return "appointment-form";
        }
        appointment.setId(id);
        appointmentRepository.save(appointment);
        return "redirect:/";
    }

}
