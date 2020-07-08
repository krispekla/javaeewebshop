/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.krispeklaric.javaeewebshop.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Kris
 */
@Entity
public class User_Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_user_role;

    private String role_name;

    private String email;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id_user_role;
    }

    public void setId(Long id) {
        this.id_user_role = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_user_role != null ? id_user_role.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User_Role)) {
            return false;
        }
        User_Role other = (User_Role) object;
        if ((this.id_user_role == null && other.id_user_role != null) || (this.id_user_role != null && !this.id_user_role.equals(other.id_user_role))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.krispeklaric.javaeewebshop.models.User_Role[ id=" + id_user_role + " ]";
    }

}
