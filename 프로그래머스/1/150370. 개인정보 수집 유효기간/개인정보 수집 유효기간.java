class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;
        Boolean[] checked = new Boolean[privacies.length];
        for (int i = 0; i < privacies.length; i++)
            checked[i] = true;

        String[] Tymd = today.split("\\.");

        String[][] t = new String[terms.length][];

        int cnt = 0;

        for(String term : terms)
            t[cnt++] = term.split(" ");


        String[][] p = new String[privacies.length][];
        cnt = 0;

        for(String privacie : privacies)
            p[cnt++] = privacie.split(" ");


        for(int i = 0; i < privacies.length; i++) {
            for (int j = 0; j < t.length; j++) {
                if(p[i][1].equals(t[j][0])) {
                    String[] day = p[i][0].split("\\.");
                    day[2] = Integer.toString(Integer.parseInt(day[2]) + 27);
                    if (Integer.parseInt(day[2]) > 28) {
                        day[2] = Integer.toString(Integer.parseInt(day[2]) - 28);
                        day[1] = Integer.toString(Integer.parseInt(day[1]) + 1);
                    }

                    day[1] = Integer.toString(Integer.parseInt(day[1]) + Integer.parseInt(t[j][1]) - 1);
                    while (Integer.parseInt(day[1]) > 12) {
                        day[1] = Integer.toString(Integer.parseInt(day[1]) - 12);
                        day[0] = Integer.toString(Integer.parseInt(day[0]) + 1);
                    }
                    if (Integer.parseInt(day[0]) > Integer.parseInt(Tymd[0])) {
                        checked[i] = false;
                    } else if (Integer.parseInt(day[0]) == Integer.parseInt(Tymd[0])) {
                        if (Integer.parseInt(day[1]) > Integer.parseInt(Tymd[1])) {
                            checked[i] = false;
                        } else if (Integer.parseInt(day[1]) == Integer.parseInt(Tymd[1])) {
                            if (Integer.parseInt(day[2]) >= Integer.parseInt(Tymd[2])) {
                                checked[i] = false;
                            }
                        }
                    }
                    System.out.println(day[0] + " " + day[1] + " " + day[2]);
                    break;
                }
            }
        }
        int n = 0;
        for (int i = 0; i < privacies.length; i++)
            if(checked[i])
                n++;
        answer = new int[n];
        n = 0;
        for (int i = 0; i < privacies.length; i++)
            if(checked[i])
                answer[n++] = i+1;

        return answer;
    }
}