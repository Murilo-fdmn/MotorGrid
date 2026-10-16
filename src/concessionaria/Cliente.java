
package concessionaria;

public class Cliente extends Pessoa {

    private String email;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpf,
            String telefone, String email) {
        super(id, nome, cpf, telefone);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String apresentarDados() {
        return "CLIENTE | "
                + super.apresentarDados()
                + " | Email: " + email;
    }
}
