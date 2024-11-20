import java.util.*;

class Program {
    static public String[] monthDays;
    static public String[] classesTime = new String[7];
    static public String[] weekDays = {"TU", "WE", "TH", "FR", "SA", "SU", "MO"};

    static public void fillArray() {
        monthDays = new String[30];
        int j = 0;
        for (int i = 0; i < 30; i++, j++) {
            monthDays[i] = weekDays[j];
            if (j + 1 == 7)
                j = -1;
        }
    }

    static public void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String[] students = new String[10];
        int[][] classSchedule = new int[7][5];
        String[][][] attendance = new String[10][30][6]; 
        int studentsNumber = 0;
        int pointsNumber = 0;

        fillArray();
        try{
            while (true) {
                String line = scan.nextLine().trim();

                if (line.equals(".")) 
                {
                    pointsNumber++;
                    continue;
                }

                if (pointsNumber == 0 && line.length() > 0 && line.length() <= 10 && studentsNumber < 10) 
                {
                    students[studentsNumber] = line;
                    studentsNumber++;
                } 
                else if (pointsNumber == 1) 
                {
                    String[] sp = line.split(" ");
                    int hour = Integer.parseInt(sp[0]);
                    String day = sp[1];

                    if (hour < 1 || hour > 6 || !Arrays.asList(weekDays).contains(day)) {
                        System.err.println("Error: Invalid input.");
                        System.exit(-1);
                    }

                    int dayIndex = Arrays.asList(weekDays).indexOf(day);
                    for (int i = 0; i < 5; i++) {
                        if (classSchedule[dayIndex][i] == 0) {
                            classSchedule[dayIndex][i] = hour;
                            break;
                        }
                    }
                } 
                else if (pointsNumber == 2) 
                {
                    String[] sp = line.split(" ");
                    String student = sp[0];
                    int hour = Integer.parseInt(sp[1]);
                    int date = Integer.parseInt(sp[2]);
                    String status = sp[3];

                    int studentIndex = -1;
                    for (int i = 0; i < studentsNumber; i++) {
                        if (students[i].equals(student)) {
                            studentIndex = i;
                            break;
                        }
                    }

                    if (studentIndex == -1 || hour < 1 || hour > 6 || date < 1 || date > 30 || 
                        (!status.equals("HERE") && !status.equals("NOT_HERE"))) {
                        System.err.println("Error: Invalid input.");
                        System.exit(-1);
                    }

                    attendance[studentIndex][date - 1][hour - 1] = status;
                }
                else if(pointsNumber == 3)
                {
                    StringBuilder timetableHeader = new StringBuilder();
                    StringBuilder[] studentRows = new StringBuilder[studentsNumber];
                
                    for (int i = 0; i < studentsNumber; i++) {
                        studentRows[i] = new StringBuilder(students[i] + " | ");
                    }
                
                    // Build the timetable header
                    // for (int day = 0; day < 30; day++) {
                    //     String currentDay = monthDays[day];
                    //     for (int hour = 1; hour <= 5; hour++) { // 1 PM to 6 PM
                    //         if (classSchedule[day][hour - 1] == 1) { // If there's a class scheduled
                    //             timetableHeader.append(hour + ":00 " + currentDay + " " + (day + 1) + "| ");
                    //             for (int student = 0; student < studentsNumber; student++) {
                    //                 if (attendance[student][day][hour - 1] != null) {
                    //                     // Add attendance status
                    //                     if (attendance[student][day][hour - 1].equals("HERE")) {
                    //                         studentRows[student].append("1| ");
                    //                     } else if (attendance[student][day][hour - 1].equals("NOT_HERE")) {
                    //                         studentRows[student].append("-1| ");
                    //                     }
                    //                 } else {
                    //                     // No attendance recorded
                    //                     studentRows[student].append(" | ");
                    //                 }
                    //             }
                    //         }
                    //     }
                    // } 4:00 WE 2| 2:00 MO 7|4:00 WE 9|2:00 MO 14|4:00 WE 16|2:00 MO 21|4:00 WE 23|2:00 MO 28|2:00 MO 30|
                    for (int day = 0;day < 30;day++)
                    {
                        String currentDay = monthDays[day];
                        System.out.println("IM HERE");

                        for (int i = 0;i < 5;i++)
                        {
                            if (classSchedule[day][i] > 0)  
                                timetableHeader.append((i + 1) + ":00" + " " + currentDay + " " + (day + 1) + "| ");
                            for (int istudent = 0;istudent < studentsNumber;istudent++)
                            {
                                if (attendance[istudent][day][i] == "HERE")
                                    studentRows[istudent].append("1| ");
                                else if (attendance[istudent][day][i] == "NOT_HERE")
                                    studentRows[istudent].append("-1| ");
                                else
                                    studentRows[istudent].append(" |");
                            }
                        }
                    }
                
                    System.out.println(timetableHeader.toString());
                    for (int i = 0; i < studentsNumber; i++) {
                        System.out.println(studentRows[i].toString());
                    }
                    break;
                }            
            }
        }catch(Exception e)
        {
            System.out.println( "-->" + e.getMessage());
        }
    }
}
