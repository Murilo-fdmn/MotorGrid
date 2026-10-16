
package concessionaria;

public class Funcionario extends Pessoa {

    private String cargo;
    private double salario;

    public Funcionario() {
    }

    public Funcionario(int id, String nome, String cpf,
            String telefone, String cargo, double salario) {
        super(id, nome, cpf, telefone);
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String apresentarDados() {
        return "FUNCIONARIO | "
                + super.apresentarDados()
                + " | Cargo: " + cargo
                + " | Salario: R$ " + salario;
    }
}
