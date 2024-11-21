import java.util.Scanner;

class Program {
    static public String[] monthDays;
    static public String[] weekDays = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};
    static public int[][] classSchedule = new int[30][5];
    static public int[][][] attendance = new int[10][30][6];  
    static public String[] students = new String[10];
    static public int studentCount = 0;

    static public void fillArray() {
        monthDays = new String[30];
        int j = 0;
        for (int i = 0; i < 30; i++, j++) {
            monthDays[i] = weekDays[j];
            if (j + 1 == 7) j = -1;
        }
    }

    static public void displayTimetable() {
        System.out.print("          ");
        for (int day = 0; day < 30; day++) {
            boolean hasClass = false;
            for (int hour = 0; hour < 5; hour++) {
                hasClass = false;
                if (classSchedule[day][hour] == 1) {
                    hasClass = true;
                }
                if (hasClass) {
                    System.out.print((hourToTime(hour + 1) + " " + monthDays[day] + " " + (day + 1) + "|"));
                }
            }
        }
        System.out.println();

        for (int i = 0; i < studentCount; i++) {
            System.out.print(students[i] + "    ");
            for (int day = 0; day < 30; day++) {
                boolean hasClass = false;
                for (int hour = 0; hour < 5; hour++) {
                    hasClass = false;
                    if (classSchedule[day][hour] == 1) 
                        hasClass = true;
                    if (hasClass) {
                        if (day < 10)
                            System.out.print("        ");
                        else
                            System.out.print("         ");
                        System.out.print(attendance[i][day][hour] + "|");
                    }
                }
            }
            System.out.println();
        }
    }

    static public String hourToTime(int hourIndex) {
        return (hourIndex ) + ":00";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        fillArray();

        int pointsNumber = 0;

        while (true) {
            String line = scan.nextLine().trim();
            if (line.equals(".")) {
                pointsNumber++;
                if (pointsNumber == 3) break;
                continue;
            }

            if (pointsNumber == 0) { 
                if (line.length() > 0 && line.length() <= 10 && studentCount < 10) {
                    students[studentCount++] = line;
                } else {
                    System.err.println("Error: Invalid student name or maximum students reached.");
                    System.exit(-1);
                }
            } else if (pointsNumber == 1) { 
                String[] sp = line.split(" ");
                if (sp.length != 2) {
                    System.err.println("Error: Invalid timetable input.");
                    System.exit(-1);
                }

                int hour = Integer.parseInt(sp[0]);
                String weekday = sp[1];

                if (hour < 0 || hour > 7    ) {
                    System.err.println("Error: Invalid hour. Classes must be between 1 PM and 6 PM.");
                    System.exit(-1);
                }

                boolean validDay = false;
                for (int day = 0; day < 30; day++) {
                    if (monthDays[day].equals(weekday)) {
                        classSchedule[day][hour - 1] = 1;
                        validDay = true;
                    }
                }
                if (!validDay) {
                    System.err.println("Error: Invalid weekday.");
                    System.exit(-1);
                }
            } else if (pointsNumber == 2) {
                String[] sp = line.split(" ");
                if (sp.length != 4) {
                    System.err.println("Error: Invalid attendance input.");
                    System.exit(-1);
                }

                String student = sp[0];
                int hour = Integer.parseInt(sp[1]); 
                int day = Integer.parseInt(sp[2]);
                String status = sp[3];

                int studentIndex = -1;
                for (int i = 0; i < studentCount; i++) {
                    if (students[i].equals(student)) {
                        studentIndex = i;
                        break;
                    }
                }

                if (studentIndex == -1 || day < 0 || day >= 30 || hour < 0 || hour > 5 || 
                    (!status.equals("HERE") && !status.equals("NOT_HERE"))) {
                    System.err.println("Error: Invalid attendance input.");
                    System.exit(-1);
                }

                attendance[studentIndex][day - 1][hour - 1] = status.equals("HERE") ? 1 : -1;
            }
        }

        displayTimetable();
    }
}
// Input
/*
oussama
.
2 MO
3 MO
4 WE
.
oussama 2 28 NOT_HERE
oussama 4 2 HERE
oussama 3 7 HERE
.
 */