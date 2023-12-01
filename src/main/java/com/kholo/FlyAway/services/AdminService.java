package com.kholo.FlyAway.services;
import com.kholo.FlyAway.Interfaces.AirlineServiceInterface;
import com.kholo.FlyAway.models.Admin;
import com.kholo.FlyAway.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService implements AirlineServiceInterface {

    private final AdminRepository adminRepository;

    @Autowired
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    // Get admin by ID
    public Optional<Admin> getAdminById(Long adminId) {
        return adminRepository.findById(adminId);
    }

    // Update admin password
    public Admin updateAdminPassword(Long adminId, String newPassword) {
        // Check if the admin with the given ID exists
        Optional<Admin> existingAdmin = adminRepository.findById(adminId);

        if (existingAdmin.isPresent()) {
            // Update the admin password
            Admin admin = existingAdmin.get();
            admin.setPassword(newPassword);
            return adminRepository.save(admin);
        } else {
            // Handle the case where the admin with the given ID is not found
            throw new IllegalArgumentException("Admin with ID " + adminId + " not found.");
        }
    }

    // Add a new admin
    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    // Delete an admin by ID
    public void deleteAdmin(Long adminId) {
        // Check if the admin with the given ID exists
        Optional<Admin> existingAdmin = adminRepository.findById(adminId);

        if (existingAdmin.isPresent()) {
            // Delete the existing admin
            adminRepository.deleteById(adminId);
        } else {
            // Handle the case where the admin with the given ID is not found
            throw new IllegalArgumentException("Admin with ID " + adminId + " not found.");
        }
    }
}
