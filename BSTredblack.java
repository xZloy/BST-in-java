public class BSTredblack {
    //22310397
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private BSTredblack left,right,root;
    private int value;
    private boolean color;
    public BSTredblack(int value){
        this.value = value;
        color = RED;
        left = null; 
        right = null;
    }
    private BSTredblack rotarIzq(BSTredblack son){
        BSTredblack x = son.right;
        son.right = x.left;
        x.left = son;
        x.color = son.color;
        son.color = RED;
        return x;
    }
    private BSTredblack rotarDer(BSTredblack son){
        BSTredblack x = son.left;
        son.left = x.right;
        x.right = son;
        x.color = son.color;
        son.color = RED;
        return x;
    }
    private void flipColor(BSTredblack son){
        son.color = RED;
        son.left.color = BLACK;
        son.right.color = BLACK;
    }
    public void push (int value){
        root = push(root,value);
        root.color = BLACK;
    }
    private boolean isRed(BSTredblack x){
        if(x==null) return false;
        return x.color == RED;
    }
    private BSTredblack push (BSTredblack son, int value){
        if(son == null){
            return new BSTredblack(value);
        }
        if(value < son.value){
            son.left = push(son.left, value);
        }else if(value > son.value){
            son.right = push(son.right, value);
        }
        if(isRed(son.right) && !isRed(son.left)){
            son = rotarIzq(son);
        }
        if(isRed(son.left) && isRed (son.left.left)){
            son = rotarDer(son);
        }
        if(isRed(son.left) && isRed(son.right)){
            flipColor(son);
        }

        return son;
    }

    public void printTree() {
        printTree(root, 0);
    }
    /*Modificacion del metodo inorder right de la clase del 2902 */
    private void printTree(BSTredblack node, int level) {
        if (node != null) {
            printTree(node.right, level + 1);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.print(node.value);
            System.out.println();
            printTree(node.left, level + 1);
        }
    }


    public static void main(String[] args) {
        BSTredblack arbol = new BSTredblack(10);
        arbol.push(20);
        arbol.push(30);
        arbol.push(15);
        arbol.push(5);
        arbol.push(25);
        arbol.push(35);
        arbol.push(5);
        arbol.push(65);
        arbol.push(75);
        arbol.push(85);
        arbol.push(95);
        arbol.push(6);
        arbol.push(4);



        System.out.println("Visualización del árbol rojo-negro:");
        arbol.printTree();
    }

}
