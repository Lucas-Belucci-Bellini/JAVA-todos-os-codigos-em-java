import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class main {
    public static void main(String[] args) {
        List<String> timeslots = Arrays.asList(
            "Seg1", "Seg2", "Seg3",
            "Ter1", "Ter2", "Ter3",
            "Qua1", "Qua2", "Qua3"
        );

        List<Professor> professors = Arrays.asList(
            new Professor("Prof A"),
            new Professor("Prof B"),
            new Professor("Prof C")
        );

        List<Room> rooms = Arrays.asList(
            new Room("Sala 101"),
            new Room("Sala 102")
        );

        List<Lesson> lessons = Arrays.asList(
            new Lesson("Turma A", "Matemática", "Prof C"),
            new Lesson("Turma A", "História", "Prof A"),
            new Lesson("Turma B", "Física", "Prof C"),
            new Lesson("Turma B", "Inglês", "Prof B"),
            new Lesson("Turma C", "Programação", "Prof A")
        );

        List<ScheduleEntry> schedule = generateSchedule(lessons, timeslots, rooms, professors);

        if (schedule == null) {
            System.out.println("Não foi possível gerar o horário com as restrições informadas.");
        } else {
            System.out.println("Horário gerado:");
            for (ScheduleEntry entry : schedule) {
                System.out.println(entry);
            }
        }
    }

    private static List<ScheduleEntry> generateSchedule(
            List<Lesson> lessons,
            List<String> timeslots,
            List<Room> rooms,
            List<Professor> professors) {
        return backtrack(lessons, timeslots, rooms, professors, 0, new ArrayList<ScheduleEntry>());
    }

    private static List<ScheduleEntry> backtrack(
            List<Lesson> lessons,
            List<String> timeslots,
            List<Room> rooms,
            List<Professor> professors,
            int index,
            List<ScheduleEntry> current) {
        if (index == lessons.size()) {
            return new ArrayList<ScheduleEntry>(current);
        }

        Lesson lesson = lessons.get(index);
        for (String slot : timeslots) {
            for (Room room : rooms) {
                if (canPlace(lesson, slot, room, current, professors)) {
                    current.add(new ScheduleEntry(lesson, slot, room));
                    List<ScheduleEntry> result = backtrack(lessons, timeslots, rooms, professors, index + 1, current);
                    if (result != null) {
                        return result;
                    }
                    current.remove(current.size() - 1);
                }
            }
        }
        return null;
    }

    private static boolean canPlace(
            Lesson lesson,
            String timeslot,
            Room room,
            List<ScheduleEntry> current,
            List<Professor> professors) {
        String professorName = lesson.professor;
        String turmaName = lesson.turma;
        String day = dayOf(timeslot);

        int professorDayCount = 0;
        for (ScheduleEntry entry : current) {
            if (entry.timeslot.equals(timeslot)) {
                if (entry.room.name.equals(room.name)) {
                    return false;
                }
                if (entry.lesson.professor.equals(professorName)) {
                    return false;
                }
                if (entry.lesson.turma.equals(turmaName)) {
                    return false;
                }
            }
            if (entry.lesson.professor.equals(professorName) && dayOf(entry.timeslot).equals(day)) {
                professorDayCount++;
                if (professorDayCount >= 2) {
                    return false;
                }
            }
        }

        return true;
    }

    private static String dayOf(String timeslot) {
        if (timeslot.length() < 3) {
            return timeslot;
        }
        return timeslot.substring(0, 3);
    }

    static class Professor {
        String name;

        Professor(String name) {
            this.name = name;
        }
    }

    static class Room {
        String name;

        Room(String name) {
            this.name = name;
        }
    }

    static class Lesson {
        String turma;
        String subject;
        String professor;

        Lesson(String turma, String subject, String professor) {
            this.turma = turma;
            this.subject = subject;
            this.professor = professor;
        }
    }

    static class ScheduleEntry {
        Lesson lesson;
        String timeslot;
        Room room;

        ScheduleEntry(Lesson lesson, String timeslot, Room room) {
            this.lesson = lesson;
            this.timeslot = timeslot;
            this.room = room;
        }

        @Override
        public String toString() {
            return String.format("%s - %s com %s na %s", timeslot, lesson.turma, lesson.professor, room.name);
        }
    }
}
