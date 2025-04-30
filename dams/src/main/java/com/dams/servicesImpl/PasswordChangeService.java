/*
 * package com.dams.servicesImpl;
 * 
 * public class PasswordChangeService {
 * 
 * public void sendOtpForPasswordChange(Long userId) { Users user =
 * userRepo.findById(userId).orElseThrow(() -> new
 * ResourceNotFoundException("User", "ID", userId));
 * 
 * String otp = String.format("%06d", new Random().nextInt(999999));
 * 
 * // Save OTP to user (or better, a separate table with expiry time)
 * user.setOtp(otp); user.setOtpExpiry(LocalDateTime.now().plusMinutes(10));
 * userRepo.save(user);
 * 
 * // Send email emailService.sendSimpleMessage(user.getEmail(),
 * "Your OTP for Password Change", "Use this OTP to change your password: " +
 * otp); }
 * 
 * public UsersDto verifyOtpAndUpdatePassword(PasswordChangeWithOtpDto dto, Long
 * userId) { Users user = userRepo.findById(userId).orElseThrow(() -> new
 * ResourceNotFoundException("User", "ID", userId));
 * 
 * if (user.getOtp() == null || !user.getOtp().equals(dto.getOtp()) ||
 * user.getOtpExpiry() == null ||
 * user.getOtpExpiry().isBefore(LocalDateTime.now())) { throw new
 * RuntimeException("Invalid or expired OTP."); }
 * 
 * // Hash and save new password String encodedPassword =
 * passwordEncoder.encode(dto.getNewPassword());
 * user.setPassword(encodedPassword); user.setUpdatedAt(LocalDateTime.now());
 * 
 * // Clear OTP user.setOtp(null); user.setOtpExpiry(null);
 * 
 * Users updatedUser = userRepo.save(user); return modelMapper.map(updatedUser,
 * UsersDto.class); }
 * 
 * }
 */