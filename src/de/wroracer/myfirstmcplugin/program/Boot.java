package de.wroracer.myfirstmcplugin.program;

import org.bukkit.entity.Player;

public class Boot {

    public static void main(String[] args) {
        String[] stringArray = new String[]{"Hallo","Tschüs"};

        System.out.println(stringArray[0]);
        System.out.println(stringArray[1]);
        stringArray[0] = "Änderung";
        System.out.println(stringArray[0]);

        int[] integerArray = new int[5];
        integerArray[0] = 187;
        integerArray[1] = 356;

        System.out.println(integerArray[0]);


    }

}
