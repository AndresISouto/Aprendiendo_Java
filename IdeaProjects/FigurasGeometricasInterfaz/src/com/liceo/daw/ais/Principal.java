package com.liceo.daw.ais;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            menu();
            int opcion = sc.nextInt();
            switch (opcion){
                case 1://triangulo
                    System.out.println("lado1 (base)");
                    double base = sc.nextDouble();
                    System.out.println("lado 2");
                    double lado2 = sc.nextDouble();
                    System.out.println("lado3");
                    double lado3 = sc.nextDouble();
                    System.out.println("altura");
                    double altura = sc.nextDouble();
                    FiguraGeometrica triangulo = new Triangulo(base,lado2,lado3,altura);
                    System.out.println("Area: "+triangulo.calcularArea()+" Perimetro; "+ triangulo.calcularPerimetro());
                    break;
                case 2://rectangulo
                    System.out.println("base");
                    double baserec = sc.nextDouble();
                    System.out.println("altura");
                    double alturarec = sc.nextDouble();
                    FiguraGeometrica rectangulo = new Rectangulo(baserec,alturarec);
                    System.out.println("Area: "+rectangulo.calcularArea()+" Perimetro; "+ rectangulo.calcularPerimetro());
                    break;
                case 3://cuadrado
                    System.out.println("lado");
                    double ladocua = sc.nextDouble();
                    FiguraGeometrica cuadrado = new Cuadrado(ladocua);
                    System.out.println("Area: "+cuadrado.calcularArea()+" Perimetro; "+ cuadrado.calcularPerimetro());
                    break;
                case 4://pentagono
                    System.out.println("lado");
                    double ladopent = sc.nextDouble();
                    System.out.println("apotema");
                    double apotema = sc.nextDouble();
                    FiguraGeometrica pentagono = new Pentagono(ladopent,apotema);
                    System.out.println("Area: "+pentagono.calcularArea()+" Perimetro; "+ pentagono.calcularPerimetro());

                    break;
                case 0:
                    System.out.println("Gracias");
                    System.exit(0);
                    break;
                default:
                    System.out.println("opción no válida");
                    break;
            }

        }while (true);
    }

    private static void menu() {
        System.out.print("""
                FIGURAS GEOMÉTRICAS
                1. Triángulo
                2. Rectángulo
                3. Cuadrado
                4. Pentágono
                0. Salir
                Escoja una opción:\s
                """);
    }
}
