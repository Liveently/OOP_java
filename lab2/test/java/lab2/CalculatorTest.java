package lab2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;



class CalculatorTest {

    @Test
    void SIMPLE()  {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));


        Calculator calc = new Calculator();

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\simple");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }


        calc.ranCalc(fileInputStream);

        assertEquals("1.0\r\n",  output.toString());
    }



    @Test
    void PLUS() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\plus");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("20.0\r\n", output.toString());
    }



    @Test
    void MINUS() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\minus");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("0.0\r\n", output.toString());
    }


    @Test
    void MULT() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\mult");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("100.0\r\n", output.toString());
    }



    @Test
    void DIV() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\div");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("1.0\r\n", output.toString());
    }


    @Test
    void SQRT() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\sqrt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("10.0\r\n", output.toString());
    }


    @Test
    void BIG() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        FileInputStream fileInputStream;

        try {
            fileInputStream = new FileInputStream("D:\\myproject\\oop\\Stack_calculator\\src\\test\\files\\big");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Calculator calc = new Calculator();

        calc.ranCalc(fileInputStream);
        assertEquals("-7.0\r\n", output.toString());
    }


}


