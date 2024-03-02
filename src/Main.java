import java.lang.Math;

class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void add(ComplexNumber Second) {
        System.out.println("Сумма: " + (this.real + Second.real) + " + " + (this.imaginary + Second.imaginary) + "i");
    }

    public void subtract(ComplexNumber Second) {
        System.out.println("Разность: " + (this.real - Second.real) + " + " + (this.imaginary - Second.imaginary) + "i");
    }

    public void multiply(ComplexNumber Second) {
        double newReal = this.real * Second.real - this.imaginary * Second.imaginary;
        double newImaginary = this.real * Second.imaginary + this.imaginary * Second.real;
        System.out.println("Результат умножения: " + newReal + " + " + newImaginary + "i");
    }

    public void divide(ComplexNumber Second) {
        double r1 = Math.sqrt(this.real * this.real + this.imaginary * this.imaginary);
        double alpha1 = Math.atan2(this.imaginary, this.real);

        double r2 = Math.sqrt(Second.real * Second.real + Second.imaginary * Second.imaginary);
        double alpha2 = Math.atan2(Second.imaginary, Second.real);

        double newR = r1 / r2;
        double newAlpha = alpha1 - alpha2;

        double newReal = newR * Math.cos(newAlpha);
        double newImaginary = newR * Math.sin(newAlpha);
        System.out.println("Результат деления: " + newReal + " + " + newImaginary + "i");
    }

    public void Sopryazh() {
        if (this.imaginary >= 0){
            System.out.println("Сопряженное: " + this.real + "- "  + this.imaginary );
        }
        else{
            System.out.println("Сопряженное: " + this.real + "+"  + Math.abs(this.imaginary) );
        }

    }

    public void power(int n) {
        double r = Math.pow(Math.sqrt(this.real * this.real + this.imaginary * this.imaginary), n);
        double alpha = Math.atan2(this.imaginary, this.real);
        double newReal = r * Math.cos(n * alpha);
        double newImaginary = r * Math.sin(n * alpha);
        System.out.println("Результат возведения: " + newReal + " + " + newImaginary + "i");
    }

    public void square() {
        double r = Math.sqrt(Math.sqrt(this.real * this.real + this.imaginary * this.imaginary));
        double alpha = Math.atan2(this.imaginary, this.real);
        ComplexNumber root1 = new ComplexNumber(r * Math.cos(alpha / 2), r * Math.sin(alpha / 2));
        ComplexNumber root2 = new ComplexNumber(r * Math.cos((alpha + 2 * Math.PI) / 2), r * Math.sin((alpha + 2 * Math.PI) / 2));

        System.out.println("Извлечение корня:");
        System.out.println(root1);
        System.out.println(root2);
    }

    
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + Math.abs(imaginary) + "i";
        }
    }
}
public class Main {
    public static void main(String[] args) {
        ComplexNumber c1 = new ComplexNumber(3, -5);
        ComplexNumber c2 = new ComplexNumber(4,8);
        ComplexNumber c3 = new ComplexNumber(1, 4);
        c1.divide(c2);
        c1.multiply(c2);
        c1.add(c2);
        c1.power(3);
        c1.square();
        c1.Sopryazh();
        c3.Sopryazh();
    }
}