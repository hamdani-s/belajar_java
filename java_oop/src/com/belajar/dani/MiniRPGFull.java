package com.belajar.dani;

import java.util.*;

public class MiniRPGFull {
    static Scanner input = new Scanner(System.in);
    static Random rand = new Random();

    static int playerHP = 100, playerMaxHP = 100;
    static int level = 1, exp = 0;
    static int baseAttack = 20; // attack dasar tanpa senjata
    static int weaponAttack = 0; // attack dari senjata yang dipakai

    static List<Item> inventory = new ArrayList<>();

    static {
        inventory.add(new Item("Potion", ItemType.POTION));
    }

    enum ItemType {
        POTION, WEAPON
    }

    static class Item {
        String name;
        ItemType type;
        int attackBonus; // untuk senjata

        Item(String name, ItemType type) {
            this(name, type, 0);
        }

        Item(String name, ItemType type, int attackBonus) {
            this.name = name;
            this.type = type;
            this.attackBonus = attackBonus;
        }

        @Override
        public String toString() {
            if (type == ItemType.WEAPON) {
                return name + "(+" + attackBonus + " ATK)";
            } else {
                return name;
            }
        }
    }

    static void ketikLambat(String teks, int delay) {
        for (char c : teks.toCharArray()) {
            System.out.print(c);
            try { Thread.sleep(delay); } catch (InterruptedException ignored) {}
        }
        System.out.println();
    }

    static void tampilkanStatus() {
        ketikLambat("HP: " + playerHP + "/" + playerMaxHP + " | Level: " + level + " | EXP: " + exp 
            + " | Attack: " + (baseAttack + weaponAttack)
            + " | Inventory: " + inventory, 10);
    }

    static String[] monsterList = {"Goblin", "Serigala", "Orc", "Zombie"};
    static int[][] monsterStats = {
        {40, 10}, {30, 12}, {50, 15}, {60, 8} // HP, attack
    };

    public static void main(String[] args) {
        ketikLambat("=== Selamat datang di Mini RPG dengan Senjata! ===", 20);

        while (true) {
            System.out.println("\n-- Petualangan Baru Dimulai! --");
            int index = rand.nextInt(monsterList.length);
            String monster = monsterList[index];
            int monsterHP = monsterStats[index][0];
            int monsterAttack = monsterStats[index][1];

            ketikLambat(">> Kamu bertemu " + monster + "!", 20);

            while (monsterHP > 0) {
                tampilkanStatus();
                ketikLambat("Monster: " + monster + " | HP: " + monsterHP, 10);

                System.out.println("1. Serang\n2. Gunakan Potion\n3. Ganti Senjata\n4. Kabur");
                System.out.print(">> Pilih tindakan: ");
                String pilihan = input.nextLine();

                switch (pilihan) {
                    case "1":
                        int totalAttack = baseAttack + weaponAttack;
                        int playerDmg = rand.nextInt(totalAttack / 2) + totalAttack / 2;
                        int monsterDmg = rand.nextInt(monsterAttack);
                        monsterHP -= playerDmg;
                        playerHP -= monsterDmg;

                        ketikLambat(">> Kamu menyerang dan memberikan " + playerDmg + " damage!", 15);
                        ketikLambat(">> " + monster + " menyerang balik dan memberikan " + monsterDmg + " damage!", 15);

                        if (playerHP <= 0) {
                            ketikLambat(">> Kamu telah dikalahkan... Game Over!", 30);
                            return;
                        }
                        break;

                    case "2": // Gunakan Potion
                        Item potion = findItemOfType(ItemType.POTION);
                        if (potion != null) {
                            playerHP += 30;
                            if (playerHP > playerMaxHP) playerHP = playerMaxHP;
                            inventory.remove(potion);
                            ketikLambat(">> Kamu menggunakan Potion dan memulihkan HP!", 15);
                        } else {
                            ketikLambat(">> Tidak ada potion di tasmu!", 15);
                        }
                        break;

                    case "3": // Ganti senjata
                        List<Item> weapons = getItemsOfType(ItemType.WEAPON);
                        if (weapons.isEmpty()) {
                            ketikLambat(">> Kamu tidak punya senjata apapun di inventory!", 15);
                            break;
                        }

                        ketikLambat("Senjata yang kamu miliki:", 10);
                        for (int i = 0; i < weapons.size(); i++) {
                            System.out.println((i+1) + ". " + weapons.get(i));
                        }
                        System.out.print("Pilih senjata untuk dipakai (0 batal): ");
                        String idxStr = input.nextLine();
                        int idx;
                        try {
                            idx = Integer.parseInt(idxStr);
                        } catch (Exception e) {
                            ketikLambat("Input tidak valid.", 15);
                            break;
                        }
                        if (idx == 0) {
                            ketikLambat("Ganti senjata dibatalkan.", 15);
                            break;
                        }
                        if (idx < 1 || idx > weapons.size()) {
                            ketikLambat("Pilihan tidak ada.", 15);
                            break;
                        }
                        weaponAttack = weapons.get(idx-1).attackBonus;
                        ketikLambat(">> Senjata kamu sekarang: " + weapons.get(idx-1).name + " dengan +" + weaponAttack + " attack.", 15);
                        break;

                    case "4":
                        ketikLambat(">> Kamu kabur dengan selamat.", 15);
                        continue;

                    default:
                        ketikLambat(">> Pilihan tidak dikenali!", 15);
                        continue;
                }
            }

            ketikLambat(">> Kamu mengalahkan " + monster + "!", 15);

            int dapatEXP = rand.nextInt(20) + 10;
            exp += dapatEXP;
            ketikLambat(">> Kamu mendapatkan " + dapatEXP + " EXP!", 15);

            if (exp >= level * 50) {
                exp = 0;
                level++;
                playerMaxHP += 20;
                baseAttack += 5;
                playerHP = playerMaxHP;
                ketikLambat(">> LEVEL UP! Sekarang kamu level " + level + "!", 30);
            }

            // Loot item: 50% potion, 30% pedang, sisanya tidak ada
            int lootRoll = rand.nextInt(100);
            if (lootRoll < 50) {
                ketikLambat(">> Kamu menemukan sebuah Potion!", 15);
                inventory.add(new Item("Potion", ItemType.POTION));
            } else if (lootRoll < 80) {
                // Loot senjata acak
                Item[] possibleWeapons = {
                    new Item("Pedang Kayu", ItemType.WEAPON, 5),
                    new Item("Pedang Besi", ItemType.WEAPON, 10),
                    new Item("Pedang Emas", ItemType.WEAPON, 15)
                };
                Item weaponLoot = possibleWeapons[rand.nextInt(possibleWeapons.length)];
                ketikLambat(">> Kamu menemukan senjata baru: " + weaponLoot + "!", 15);
                inventory.add(weaponLoot);
            } else {
                ketikLambat(">> Tidak ada loot kali ini.", 15);
            }
        }
    }

    static Item findItemOfType(ItemType type) {
        for (Item item : inventory) {
            if (item.type == type) return item;
        }
        return null;
    }

    static List<Item> getItemsOfType(ItemType type) {
        List<Item> result = new ArrayList<>();
        for (Item item : inventory) {
            if (item.type == type) result.add(item);
        }
        return result;
    }
}