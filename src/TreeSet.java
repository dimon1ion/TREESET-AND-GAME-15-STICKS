import java.util.ArrayList;

public class TreeSet {

    private StudentNode studentMainNode;

    private final Comparable compareMethod;

    public TreeSet(Comparable compareMethod) {
        this.compareMethod = compareMethod;
    }

    public void AddStudent(String name, String surname, float avg){
        StudentNode studentNew = new StudentNode(name, surname, avg);
        if (this.studentMainNode == null){
            this.studentMainNode = studentNew;
            return;
        }
        studentMainNode.addStudent(studentNew, studentMainNode);
    }

    public ArrayList<StudentNode> GetAllStudents(){
        ArrayList<StudentNode> studentNodes = new ArrayList<>();
        studentMainNode.GetAll(studentNodes);
        return studentNodes;
    }

    class StudentNode {
        private String name;
        private String surname;
        private float avgBal;

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public float getAvgBal() {
            return avgBal;
        }

        private StudentNode next;
        private StudentNode prev;

        StudentNode(String name, String surname, float avgBal) {
            this.name = name;
            this.surname = surname;
            this.avgBal = avgBal;
        }

        public void addStudent(StudentNode studentNodeNew, StudentNode selectedStudentNode){

            if (compareMethod.Compare(selectedStudentNode, studentNodeNew)){
                if (selectedStudentNode.next == null){
                    selectedStudentNode.next = studentNodeNew;
                }
                else {
                    selectedStudentNode.next.addStudent(studentNodeNew, this);
                }
            }
            else {
                if (selectedStudentNode.prev == null){
                    selectedStudentNode.prev = studentNodeNew;
                }
                else {
                    selectedStudentNode.prev.addStudent(studentNodeNew, this);
                }
            }
        }

        public void GetAll(ArrayList<StudentNode> studentNodes){
            if (prev != null){
                prev.GetAll(studentNodes);
            }
            studentNodes.add(this);
            if (next != null){
                next.GetAll(studentNodes);
            }
        }

        @Override
        public String toString() {
            return String.format("Name:%s Surname:%s Avg:%s\n", name, surname, avgBal);
        }
    }

//    @Override
//    public boolean Compare(Student student) {
//
//        return true;
//    }

}
