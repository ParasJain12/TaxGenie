package com.taxgenie.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taxgenie.model.User;
import com.taxgenie.repository.UserRepository;

@Controller
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/register")
	public String registerGet() {
		return "register";
	}

	@PostMapping("/register")
	public String registerPost(@ModelAttribute("user") User user, HttpServletRequest request) throws ServletException {
		String password = user.getPassword();
		user.setPassword(bCryptPasswordEncoder.encode(password));
		userRepository.save(user);
		request.login(user.getEmail(), password);
		return "redirect:/login";
	}

	@GetMapping("/forgotpassword")
	public String forgotPasswordGet() {
		return "forgotpassword";
	}

	@PostMapping("/forgotpassword")
	public String forgotPasswordPost(@RequestParam("email") String email, Model model) {
		User user = userRepository.findByEmail(email);

		if (user == null) {
			model.addAttribute("error", "No account found with that email address.");
			return "forgotpassword";
		}

		// Generate unique token
		String token = UUID.randomUUID().toString();
		user.setResetToken(token);
		user.setResetTokenExpiry(LocalDateTime.now().plusMinutes(30)); // valid for 30 mins
		userRepository.save(user);

		// Send email
		String resetLink = "http://localhost:8080/resetpassword?token=" + token;
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("jainsahabparas678@gmail.com");
		message.setTo(user.getEmail());
		message.setSubject("TaxGenie - Password Reset Request");
		message.setText("Hello " + user.getFirstName() + ",\n\n"
				+ "Click the link below to reset your password. This link expires in 30 minutes.\n\n"
				+ resetLink + "\n\n"
				+ "If you did not request this, please ignore this email.\n\n"
				+ "Regards,\nTaxGenie Team");
		mailSender.send(message);

		model.addAttribute("success", "Password reset link has been sent to your email.");
		return "forgotpassword";
	}

	@GetMapping("/resetpassword")
	public String resetPasswordGet(@RequestParam("token") String token, Model model) {
		User user = userRepository.findByResetToken(token);

		if (user == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
			model.addAttribute("error", "Invalid or expired reset link. Please try again.");
			return "forgotpassword";
		}

		model.addAttribute("token", token);
		return "resetpassword";
	}

	@PostMapping("/resetpassword")
	public String resetPasswordPost(@RequestParam("token") String token,
									@RequestParam("password") String password,
									Model model) {
		User user = userRepository.findByResetToken(token);

		if (user == null || user.getResetTokenExpiry().isBefore(LocalDateTime.now())) {
			model.addAttribute("error", "Invalid or expired reset link. Please try again.");
			return "forgotpassword";
		}

		// Update password and clear token
		user.setPassword(bCryptPasswordEncoder.encode(password));
		user.setResetToken(null);
		user.setResetTokenExpiry(null);
		userRepository.save(user);

		model.addAttribute("success", "Password reset successful! You can now login.");
		return "login";
	}
}