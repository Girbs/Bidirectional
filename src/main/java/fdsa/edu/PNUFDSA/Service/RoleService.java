/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fdsa.edu.PNUFDSA.Service;

import fdsa.edu.PNUFDSA.Model.Role;
import fdsa.edu.PNUFDSA.Repository.RoleDAO;
import java.util.Optional;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jephthé Gédéon
 */
@Data
@Service
public class RoleService {
     @Autowired
    private RoleDAO roleDAO;

    public Optional<Role> getRole(final int id) {
        return roleDAO.findById(id);
    }

    public Iterable<Role> getRole() {
        return roleDAO.findAll();
    }

    public void deleteRole(final int id) {
        roleDAO.deleteById(id);
    }

    public Role saveRole(Role Role) {
        Role savedRole = roleDAO.save(Role);
        return savedRole;
    }
    
}
