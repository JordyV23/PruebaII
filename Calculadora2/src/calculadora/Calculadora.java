/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *agrego el codigo de la operacion -, Juan Carlos
 */
package calculadora;

import javax.swing.JTextField;

/**
 *
 * @author jordy
 */
public class Calculadora {

    private double resultado;
    private String val1, val2;

    public void escribir(JTextField Campo, String valor) {
        Campo.setText(Campo.getText() + valor);
    }

    private void separar(JTextField Campo, String valor) {
        val1 = Campo.getText().substring(0, Campo.getText().indexOf(valor));
        val2 = Campo.getText().substring(Campo.getText().indexOf(valor) + 1, Campo.getText().length());
    }

    private boolean contiene(JTextField Campo, String valor) {
        return Campo.getText().contains(valor);
    }

    public void sumar(JTextField Campo) {
        System.out.println(val1);
        System.out.println(val2);
        try{
            resultado = Double.parseDouble(val1) + Double.parseDouble(val2);
            this.escribir(Campo,Double.toString(resultado));
        } catch (Exception e){
            this.escribir(Campo,"Error");
        }
    }

    public void Multiplicar(JTextField Campo){
        System.out.println(val1);
        System.out.println(val2);
        try{
            resultado = Double.parseDouble(val1) * Double.parseDouble(val2);
            this.escribir(Campo,Double.toString(resultado));
        } catch (Exception e){
            this.escribir(Campo,"Error");
        }
    }

    public void restar(JTextField Campo){
        try{
            resultado = Double.parseDouble(val1) - Double.parseDouble(val2);
            this.escribir(Campo,Double.toString(resultado));
        } catch (Exception e){
            this.escribir(Campo,"Error");
        }
    }

    public void Resolver(JTextField Campo) {
        if (contiene(Campo, "+")) {
            this.separar(Campo, "+");
            //Sumar
            sumar(Campo);
            //System.out.println("Sumar: " + val1 +" + "+val2);
        } else if (contiene(Campo, "-")) {
            this.separar(Campo, "-");
            //Restar
             System.out.println("Restar: " + val1 +" - "+val2);
        } else if (contiene(Campo, "/")) {
            this.separar(Campo, "/");
            //Dividir
            this.dividir(Campo); 
             System.out.println("Dividir: " + val1 +" / "+val2);
        } else if (contiene(Campo, "X")) {
           this.separar(Campo, "X");
           //Multiplicar
            System.out.println("Multiplicar: " + val1 +" X "+val2);
            this.Multiplicar(Campo);
        }
    }

    public void limpiar(JTextField Campo) {
        Campo.setText("");
    }

    public Calculadora() {
        this.resultado = 0.0;
        this.val1 = "0";
        this.val2 = "0";
    }

    public void dividir(JTextField Campo) {
        if(this.val1.equals("0") || this.val2.equals("0")){
            this.escribir(Campo,"Error");
        } else {
            try{
                resultado= Double.parseDouble(val1) /Double.parseDouble(val2);
                this.escribir(Campo,Double.toString(resultado));
            } catch(Exception e) {
                this.escribir(Campo, "Error");
            }
        }   
    }
    
    


}
