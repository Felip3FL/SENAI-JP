package introducao;

import javax.swing.JOptionPane;

public class BemVindo {
  public static void main(String[] args) {
    String txt = JOptionPane.showInputDialog("Digite seu nome");
    JOptionPane.showMessageDialog(null, txt + ": seja bem vindo!");
    System.exit(0);
  }
}