package songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numSongs = Integer.parseInt(scanner.nextLine());

        List<Song> songs = new ArrayList<>();

        for (int i = 0; i < numSongs; i++) {
            String[] currentSong = scanner.nextLine().split("_");
            Song song = new Song(currentSong[0], currentSong[1], currentSong[2]);
            songs.add(song);
        }
        String typeList = scanner.nextLine();

        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (song.getTypeList().equals(typeList)) {
                    System.out.println(song.getName());
                }

            }
        }
    }
}
