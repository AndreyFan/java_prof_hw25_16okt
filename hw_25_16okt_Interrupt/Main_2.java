package de.telran.hw_25_16okt_Interrupt;

public class Main_2 {
    // Задание : 1. Запустите в 3 потока просчет количества всех
// простых чисел в интервале от 2 до 1000000.
//с визуализацией просчета.
//Через 5 секунд завершите принудительно выполнение 1-го потока
// командой из главного.
//Через 10 секунд завершите и 2-й поток.
//Через 15 секунд - 3-й поток.
//Время подкорректируйте под скорость своего компьютера.
    public static void main(String[] args) throws InterruptedException {
        // Создаем анонимный класс потока для каждого потока
        Thread t = new Thread(() -> {

            System.out.println(" начало выполнения потока 1");

            int count = 0;
            for (int i = 2; i < 1000_000; i++) {
                if (Thread.interrupted()) { // проверка isInterrupted
                    System.out.println("Принудительно останавливаем поток № 1 . Текущее количество простых чисел = " + count);
                    return; // завершаем работу потока, если необходимо!
                }
                boolean isPrime = true;
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                    if (count % 1000 == 0) // это сделал чтобы проще было просмотреть ход выполнения
                        System.out.println(" текущее значение кол-ва Простых чисел потока 1 =  " + count);
                }
            }
        });

        Thread t2 = new Thread(() -> {

            System.out.println(" начало выполнения потока 2");

            int count = 0;
            for (int i = 2; i < 1000_000; i++) {
                if (Thread.interrupted()) { // проверка isInterrupted
                    System.out.println("Принудительно останавливаем поток № 2 . Текущее количество простых чисел = " + count);
                    return; // завершаем работу потока, если необходимо!
                }
                boolean isPrime = true;
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                    if (count % 1000 == 0)
                        System.out.println(" текущее значение кол-ва Простых чисел потока 2 =  " + count);
                }
            }
        });

        Thread t3 = new Thread(() -> {

            System.out.println(" начало выполнения потока 3");

            int count = 0;
            for (int i = 2; i < 1000_000; i++) {
                if (Thread.interrupted()) { // проверка isInterrupted
                    System.out.println("Принудительно останавливаем поток № 3 . Текущее количество простых чисел = " + count);
                    return; // завершаем работу потока, если необходимо!
                }
                boolean isPrime = true;
                for (int k = 2; k < i; k++) {
                    if (i % k == 0) {
                        isPrime = false;
                        break;
                    }
                }

                if (isPrime) {
                    count++;
                    if (count % 1000 == 0)
                        System.out.println(" текущее значение кол-ва Простых чисел потока 3 =  " + count);
                }
            }
        });

        t.start();
        t2.start();
        t3.start();
        Thread.sleep(5000);
        t.interrupt();

        Thread.sleep(5000);
        t2.interrupt();

        Thread.sleep(5000);
        t3.interrupt();

        t.join();
        t2.join();
        t3.join(); // этот блок нужен чтобы все потоки успели нормально остановится до окончания основного потока

        System.out.println(" Завершение главного потока программы ");
    }
}
