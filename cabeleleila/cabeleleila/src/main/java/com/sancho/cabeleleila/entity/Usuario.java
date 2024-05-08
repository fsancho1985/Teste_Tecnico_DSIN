package com.sancho.cabeleleila.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUsuario;
    private String nome;
    private String email;
    private String password;

    public Usuario() {
    }

    public Usuario(Long codigoUsuario, String nome, String email, String password) throws NoSuchAlgorithmException {
        this.codigoUsuario = codigoUsuario;
        this.nome = nome;
        this.email = email;
        this.password = hashPassword(password);
    }



    public Long getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(Long codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = hashPassword(password);
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigoUsuario=" + codigoUsuario +
                ", nome='" + nome + '\'' +
                '}';
    }
}
