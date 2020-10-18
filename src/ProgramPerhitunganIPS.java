import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class ProgramPerhitunganIPS {
    private static final List<List> arrayMatakuliah = new ArrayList<>();
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            mainMenu();
        }
    }

    private static void mainMenu() {
        System.out.println("Pendataan dan Perhitungan IPS (Indeks Prestasi Semester)");
        System.out.println("1. Pendataan Matakuliah");
        System.out.println("2. Perhitungan IPS");
        System.out.println("3. Update Grade");
        System.out.println("4. Keluar");
        System.out.print("Masukkan pilihan Anda : ");
        String pilihan = input.next();

        switch (pilihan) {
            case "1":
                pendataanMatakuliah();
                break;
            case "2":
                perhitunganIPS();
                break;
            case "3":
                updateGrade();
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.print("Masukkan pilihan antara 1 s/d 4 : ");
                break;
        }
    }

    private static void pendataanMatakuliah() {
        System.out.print("Masukkan Jumlah Mata Kuliah : ");
        int totalMakul = input.nextInt();
        for (int i = 0; i < totalMakul; i++) {
            List<String> arrayInput = new ArrayList<>();
            Scanner makul = new Scanner(System.in);
            System.out.println();
            System.out.print("Masukkan Kode Matakuliah : ");
            String kodeMakul = makul.nextLine();
            System.out.print("Masukkan Nama Matakuliah : ");
            String namaMakul = makul.nextLine();
            System.out.print("Masukkan Grade Matakuliah : ");
            String gradeMatakuliah = makul.nextLine().toUpperCase();

            String[] allowedMakul = {"A", "B", "C", "D", "E"};
            List<String> list = Arrays.asList(allowedMakul);
            while (!list.contains(gradeMatakuliah)) {
                System.out.print("Masukkan Grade Matakuliah A s/d E : ");
                gradeMatakuliah = input.nextLine().toUpperCase();
            }
            System.out.print("Masukkan Jumlah SKS : ");
            int jumlahSKS = makul.nextInt();

            arrayInput.add(kodeMakul);
            arrayInput.add(namaMakul);
            arrayInput.add(gradeMatakuliah);
            arrayInput.add(String.valueOf(jumlahSKS));
            arrayMatakuliah.add(arrayInput);
        }
    }

    private static void perhitunganIPS() {
        if (arrayMatakuliah.size() < 1) {
            System.out.println("Belum ada data Matakuliah yang dimasukkan");
        } else {
            System.out.println("Matakuliah yang Anda ambil adalah: ");
            int gradeSKS = 0;
            double totalGradeSKS = 0;
            double countSKS = 0;
            for (List list : arrayMatakuliah) {
                String kdMatakuliah = list.get(0).toString();
                String nmMatakuliah = list.get(1).toString();
                String grMataKuliah = list.get(2).toString().toUpperCase();
                String sksMatakuliah = list.get(3).toString();

                System.out.println(kdMatakuliah + "    " + nmMatakuliah + "    " + grMataKuliah + "    " + sksMatakuliah);
                int grade;
                switch (grMataKuliah) {
                    case "A":
                        grade = 4;
                        break;
                    case "B":
                        grade = 3;
                        break;
                    case "C":
                        grade = 2;
                        break;
                    case "D":
                        grade = 1;
                        break;
                    default:
                        grade = 0;
                        break;
                }
                gradeSKS = grade * Integer.parseInt(sksMatakuliah);
                totalGradeSKS = totalGradeSKS + gradeSKS;
                countSKS = countSKS + Integer.parseInt(sksMatakuliah);
            }

            double nilaiIPS = totalGradeSKS / countSKS;
            System.out.println("Nilai IPS Anda adalah " + nilaiIPS);
        }
    }

    private static void updateGrade() {
        if (arrayMatakuliah.size() < 1) {
            System.out.println("Belum ada data Matakuliah yang dimasukkan");
        } else {
            System.out.print("Masukkan kode Matakuliah : ");
            String kodeMatakuliah = input.next();
            for (int i = 0; i < arrayMatakuliah.size(); i++) {
                List<String> arrayInput = new ArrayList<>();
                String kdMatakuliah = (arrayMatakuliah.get(i)).get(0).toString();
                String nmMatakuliah = (arrayMatakuliah.get(i)).get(1).toString();
                String sksMatakuliah = (arrayMatakuliah.get(i)).get(3).toString();
                if (kodeMatakuliah.equals(kdMatakuliah)) {
                    if (!kdMatakuliah.isEmpty()) {
                        Scanner update = new Scanner(System.in);
                        System.out.print("Masukkan Grade Matakuliah : ");
                        String gradeMatakuliah = update.nextLine().toUpperCase();
                        String[] allowedMakul = {"A", "B", "C", "D", "E"};
                        List<String> list = Arrays.asList(allowedMakul);
                        while (!list.contains(gradeMatakuliah)) {
                            System.out.print("Masukkan Grade Matakuliah A s/d E : ");
                            gradeMatakuliah = input.nextLine().toUpperCase();
                        }

                        arrayInput.add(kdMatakuliah);
                        arrayInput.add(nmMatakuliah);
                        arrayInput.add(gradeMatakuliah);
                        arrayInput.add(String.valueOf(sksMatakuliah));

                        arrayMatakuliah.set(i, arrayInput);

                        arrayMatakuliah.forEach(value -> {
                            String updateKdMatakuliah = value.get(0).toString();
                            String updateNmMatakuliah = value.get(1).toString();
                            String updateGrMatakuliah = value.get(2).toString().toUpperCase();
                            String updateSksMatakuliah = value.get(3).toString();
                            System.out.println(updateKdMatakuliah + "    " + updateNmMatakuliah + "    " + updateGrMatakuliah + "    " + updateSksMatakuliah);
                            System.out.println();
                        });
                    } else
                        System.out.println("Kode Matakuliah tidak ditemukan. ");
                }
            }
        }
    }
}
