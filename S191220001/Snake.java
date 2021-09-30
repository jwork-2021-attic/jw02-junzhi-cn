package S191220001;
public class Snake {

    private static Snake theSnake;

    public static Snake getTheSnake() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {

    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Line line,Monster[] mons) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = line.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step,mons);
            System.out.println(line.toString());
            log += line.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step, Monster[] mons) {
        String[] couple = step.split("<->");
        int temp1 = -1, temp2 = -1;
        for (int i = 0; i < mons.length; i++) {
            if (mons[i].getValue() == Integer.parseInt(couple[0])) {
                temp1 = i;
            }
            if (mons[i].getValue() == Integer.parseInt(couple[1])) {
                temp2 = i;
            }
        }
        mons[temp1].swapPosition(mons[temp2]);
    }


}
