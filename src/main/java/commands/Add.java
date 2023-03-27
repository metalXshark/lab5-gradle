package commands;

import commands.manager.Command;
import commands.manager.CreateObject;
import commands.manager.CreateObjectMassage;
import dragon.Color;
import dragon.DragonCharacter;
import dragon.DragonType;

import java.util.ArrayList;
import java.util.Scanner;

public class Add extends Command {
    public ArrayList<String> arguments = new ArrayList<>();
    @Override
    protected void execute(String[] commandName) {
        Scanner in = new Scanner(System.in);
        for (int k = 1; k < 13; k++) {
            String mas = "MASSAGE_" + k;
            CreateObjectMassage.valueOf(mas).getMessage();
            String argument = in.nextLine().trim();
            switch (k){
                case 1, 8, 11:
                    while(argument.equals("")) {
                        CreateObjectMassage.ERROR_MASSAGE_1.getMessage();
                        CreateObjectMassage.valueOf(mas).getMessage();
                        argument = in.nextLine().trim();
                    }
                    if (k == 11){
                        while (argument.length() > 44){
                            CreateObjectMassage.ERROR_MASSAGE_5.getMessage();
                            CreateObjectMassage.valueOf(mas).getMessage();
                            argument = in.nextLine().trim();
                        }
                    }
                    arguments.add(argument);
                    break;
                case 2:
                    Float x = null;
                    while (x == null){
                        try {
                            x = Float.parseFloat(argument);
                            while (x <= -572) {
                                CreateObjectMassage.ERROR_MASSAGE_2.getMessage();
                                CreateObjectMassage.valueOf(mas).getMessage();
                                x = Float.parseFloat(in.nextLine().trim());
                            }
                            arguments.add(String.valueOf(x));
                        } catch (NumberFormatException e){
                            CreateObjectMassage.ERROR_MASSAGE_3.getMessage();
                            CreateObjectMassage.valueOf(mas).getMessage();
                            x = null;
                            argument = in.nextLine().trim();
                        }
                    }
                    break;
                case 3, 4, 9, 10:
                    Long y = null;
                    while (y == null){
                        try {
                            y = Long.parseLong(argument);
                            if(k == 3){
                                arguments.add(String.valueOf(y));
                            } else {
                                while (y <= 0) {
                                    CreateObjectMassage.ERROR_MASSAGE_4.getMessage();
                                    CreateObjectMassage.valueOf(mas).getMessage();
                                    y = Long.parseLong(in.nextLine().trim());
                                }
                                arguments.add(String.valueOf(y));
                            }
                        } catch (NumberFormatException e){
                            CreateObjectMassage.ERROR_MASSAGE_3.getMessage();
                            CreateObjectMassage.valueOf(mas).getMessage();
                            y = null;
                            argument = in.nextLine().trim();
                        }
                    }
                    break;
                case 5, 6, 7, 12:
                    boolean z = false;
                    while (!z){
                        try{
                            if (k == 5){
                                Color color = Color.valueOf(argument);
                                arguments.add(String.valueOf(color));
                            } else if (k == 6) {
                                DragonType type = DragonType.valueOf(argument);
                                arguments.add(String.valueOf(type));
                            } else if (k == 7) {
                                DragonCharacter character = DragonCharacter.valueOf(argument);
                                arguments.add(String.valueOf(character));
                            } else {
                                Color eyeColor = Color.valueOf(argument);
                                arguments.add(String.valueOf(eyeColor));
                            }
                            z = true;
                        } catch (IllegalArgumentException e){
                            CreateObjectMassage.ERROR_MASSAGE_3.getMessage();
                            CreateObjectMassage.valueOf(mas).getMessage();
                            z = false;
                            argument = in.nextLine().trim();
                        }
                    }
                    break;
            }
        }
        collectionManager.add(CreateObject.createDragon(arguments));
        arguments.clear();
        successResult();
    }
}
