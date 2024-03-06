public class Treev2 {
    private Treev2 left;
    private Treev2 right;
    private int value;
    private int valueroot;

    public Treev2(int value) {
        this.value = value;
        //this.valueroot = valueroot;
        this.left = null;
        this.right = null;
    }

    int getValue() {
        return value;
    }
    public void setValueroot(int valueroot) {
        this.valueroot = valueroot;
    }

    public void push(int value) {
        Treev2 newbranch = new Treev2(value);
        if ( newbranch.getValue()<valueroot) {
            if (left == null) {
                left = newbranch;
            } else {
                left.push(value);
            }
        } else if (newbranch.getValue()>valueroot) {
            if (right == null) {
                right = newbranch;
            } else {
                right.push(value);
            }
        }
    }

    public void preorderLeft() {
        System.out.println(value + " , ");
        if (left != null) {
            left.preorderLeft();
        }
        if (right != null) {
            right.preorderLeft();
        }
    }

    public void preorderRight() {
        System.out.println(value + ",");
        if (right != null) {
            right.preorderRight();
        }
        if (left != null) {
            left.preorderRight();
        }
    }

    public void postorderLeft() {
        if (left != null) {
            left.postorderLeft();
        }
        if (right != null) {
            right.postorderLeft();
        }
        System.out.println(value + ", ");
    }

    public void postorderRight() {
        if (right != null) {
            right.postorderLeft();
        }
        if (left != null) {
            left.postorderLeft();
        }
        System.out.println(value + ", ");
    }

    public void inorderLeft() {
        if (left != null) {
            left.inorderLeft();
        }
        System.out.println(value + ",");
        if (right != null) {
            right.inorderLeft();
        }
    }

    public void inorderRight() {
        if (right != null) {
            right.inorderRight();
        }
        System.out.println(value + ",");
        if (left != null) {
            left.inorderRight();
        }
    }

    public static void main(String args[]) {
        Treev2 arbol = new Treev2(5);
        arbol.setValueroot(5);
        arbol.push(3);
        arbol.push(7);
        arbol.push(2);
        arbol.push(4);
        System.out.println("Recorrido preorder left");
        arbol.preorderLeft();
        System.out.println("Recorrido preorder right");
        arbol.preorderRight();
        System.out.println("Recorrido postorder left");
        arbol.postorderLeft();
        System.out.println("Recorrido postorder right");
        arbol.postorderRight();
        System.out.println("Recorrido inorder left");
        arbol.inorderLeft();
        System.out.println("Recorrido inorder right");
        arbol.inorderRight();
    }

}