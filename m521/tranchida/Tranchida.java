/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package m521.tranchida;

import java.util.Arrays;

/**
 *
 * @author anna
 */
public class Tranchida {

    static {
        try {
            System.setOut(new java.io.PrintStream(
                    new java.io.FileOutputStream(java.io.FileDescriptor.out), true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            //System.out.println("VM dont support UTF-8");
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        char[][] tableau = tabDim();
//        remplir(tableau);
        System.out.println("Cas : 1");
        cas1(tableau);
        affiche(tableau);
        System.out.println(" ");
        System.out.println("Cas : 3");
        cas3(tableau);
        affiche(tableau);

//                    
//            
//           
    }

    public static char[][] tabDim() {
        java.util.Scanner scanner = new java.util.Scanner(System.in)
                .useLocale(new java.util.Locale.Builder()
                        .setLanguage("CH")
                        .setRegion("fr")
                        .build());
        System.out.println("Veuillez choisir la taille du tableau (minimum 7x7)");
        int un;
        int deux;
        do {
            System.out.println("Première dimension : ");
            un = scanner.nextInt();
            scanner.nextLine();
            if (un < 7) {
                System.out.println("Trop petit, veuillez saisir une valeur plus grande ou égale à 7 :");
            }
        } while (un < 7);
        do {
            System.out.println("Deuxième dimension : ");
            deux = scanner.nextInt();
            scanner.nextLine();
            if (deux < 7) {
                System.out.println("Trop petit, veuillez saisir une valeur plus grande ou égale à 7 :");
            }
        } while (deux < 7);
        char[][] tableau = new char[un][deux];
        return (tableau);
    }

    public static void remplir(char[][] tabl) {
        //Ascii table char majuscule 65-90
        for (int i = 0; i < tabl.length; i++) {
            for (int j = 0; j < tabl[0].length; j++) {
                tabl[i][j] = (char) aleat(65, 90);
            }

        }
    }

    public static char[][] affiche(char[][] tab) {

        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[0].length; j++) {
                System.out.print(tab[i][j]);
                System.out.print(' ');
            }
            System.out.println();

        }

        return (tab);

    }

    public static char[][] cas3(char[][] tabTrois) {
        remplir(tabTrois);
        int index = aleat(0, tabTrois[0].length - 1);

        String prenom = "CHARLIE";
        for (int k = 0; k < prenom.length(); k++) {

            tabTrois[k][index] = prenom.charAt(k);

        }

        return tabTrois;

    }

    public static char[][] cas1(char[][] tabUn) {
        remplir(tabUn);

        int index = aleat(0, tabUn.length - 1);
       
        String prenom = "CHARLIE";
        for (int k = 0; k < prenom.length(); k++) {

            tabUn[index][k] = prenom.charAt(k);
//                    
        }

        return tabUn;

    }

    private static int aleat(int borneMin, int borneMax) {
        return (char) (Math.random() * (borneMax - borneMin + 1)) + borneMin;
    }
}
