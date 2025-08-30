import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SpotifyPlaylistSimulation {
    private static ArrayList<String> playlist = new ArrayList<>();
    private static Stack<ArrayList<String>> undoStack = new Stack<>();
    private static Stack<ArrayList<String>> redoStack = new Stack<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=== Spotify Playlist Simulation ===");
            System.out.println("1. Add song");
            System.out.println("2. Remove last song");
            System.out.println("3. Undo");
            System.out.println("4. Redo");
            System.out.println("5. View playlist");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addSong();
                    break;
                case 2:
                    removeSong();
                    break;
                case 3:
                    undo();
                    break;
                case 4:
                    redo();
                    break;
                case 5:
                    viewPlaylist();
                    break;
                case 6:
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 6);
    }

    private static void addSong() {
        System.out.print("Enter song name: ");
        String song = scanner.nextLine();

        // Save current state before modifying
        undoStack.push(new ArrayList<>(playlist));
        redoStack.clear();

        playlist.add(song);
        System.out.println("\"" + song + "\" added to playlist.");
    }

    private static void removeSong() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty. No song to remove.");
            return;
        }

        // Save current state before modifying
        undoStack.push(new ArrayList<>(playlist));
        redoStack.clear();

        String removedSong = playlist.remove(playlist.size() - 1);
        System.out.println("\"" + removedSong + "\" removed from playlist.");
    }

    private static void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo.");
            return;
        }

        redoStack.push(new ArrayList<>(playlist)); // Save current state
        playlist = undoStack.pop(); // Restore previous state
        System.out.println("Undo successful.");
    }

    private static void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo.");
            return;
        }

        undoStack.push(new ArrayList<>(playlist)); // Save current state
        playlist = redoStack.pop(); // Restore next state
        System.out.println("Redo successful.");
    }

    private static void viewPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("\nCurrent Playlist:");
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println((i + 1) + ". " + playlist.get(i));
            }
        }
    }
}
