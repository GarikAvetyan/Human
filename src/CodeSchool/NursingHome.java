package CodeSchool;

public class NursingHome {
    private Human[] retirees;

    //Default Constructor
    NursingHome() {

    }

    //Constructor
    NursingHome(Human humans[]) {
        setRetirees(humans);
    }

    //Returess to String
    public void toStringReturees() {
        System.out.println("\nNursing home people:");
        for (int i = 0; i < retirees.length; i++) {
            System.out.println(retirees[i].toString());
        }
    }

    //set
    public void setRetirees(Human humans[]) {

        int retireesLength = 0;
        for (int i = 0; i < humans.length; i++) {
            if (humans[i].getAge() >= 65) {
                retireesLength++;
            }
        }

        retirees = new Human[retireesLength];
        int index = 0;
        for (int i = 0; i < humans.length; i++) {

            if (humans[i].getAge() >= 65) {
                retirees[index] = humans[i];
                index++;
            }

        }
    }
}
