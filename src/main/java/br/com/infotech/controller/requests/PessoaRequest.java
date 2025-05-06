package br.com.infotech.controller.requests;

import jakarta.validation.constraints.*;

public class PessoaRequest {

    private String id;
    @NotBlank(message = "A descricao não pode estar em branco.")
    @Size(min = 5, max = 30, message = "A descricao deve ter entre 5 e 30 caracteres.")
    private String username;
    @NotNull(message = "O preço não pode ser nulo.")
    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero.")
    @Digits(integer = 10, fraction = 2, message = "O preço deve ter no máximo 10 dígitos inteiros e 2 dígitos decimais.")
    private String email;
    @NotNull(message = "A quantidade não pode ser nula.")
    @Min(value = 1, message = "A quantidade deve ser no mínimo 1.")
    @Max(value = 1000, message = "A quantidade deve ser no máximo 1000.")
    private String senha;
    @NotBlank(message = "O lote não pode estar vazio.")
    @Size(min = 3, max = 15, message = "O lote deve ter entre 3 e 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z0-9-]+$", message = "O lote deve conter apenas letras, números e traços.")

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
