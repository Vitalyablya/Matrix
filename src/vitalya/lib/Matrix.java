package vitalya.lib;

public class Matrix {

    private double[][] matrix;
    private int sizeX;
    private int sizeY;

    public Matrix(double[][] a) throws Exception{ // создание матрицы через параметр

        sizeY = a.length;
        sizeX = a[0].length;

        for(int i = 0; i<sizeY; i++){
            if(a[i].length != sizeX) throw new Exception("Массив не должен быть c разным размером по Y");
        }

        matrix = a;
    }

    static public Matrix sum(Matrix a, Matrix b) throws Exception {//сумма 2 матриц возвращает значение в другой объект(при этом создание новой матрицы)
         double[][] sum_matrix = new double[a.getMatrix().length][a.getMatrix()[0].length];

        if(a.getMatrix().length != b.getMatrix().length || a.getMatrix()[0].length != b.getMatrix()[0].length) throw new Exception("Матрицы разные");
        for(int i = 0; i < a.getMatrix().length; i++) for (int k = 0; k < a.getMatrix()[0].length; k++ ) sum_matrix[i][k] = a.getMatrix()[i][k] + b.getMatrix()[i][k];
        return new Matrix(sum_matrix);
    }

    static public Matrix diff(Matrix a, Matrix b) throws Exception {//сумма 2 матриц возвращает значение в другой объект(при этом создание новой матрицы)
        double[][] sum_matrix = new double[a.getMatrix().length][a.getMatrix()[0].length];

        if(a.getMatrix().length != b.getMatrix().length || a.getMatrix()[0].length != b.getMatrix()[0].length) throw new Exception("Матрицы разные");
        for(int i = 0; i < a.getMatrix().length; i++) for (int k = 0; k < a.getMatrix()[0].length; k++ ) sum_matrix[i][k] = a.getMatrix()[i][k] - b.getMatrix()[i][k];
        return new Matrix(sum_matrix);
    }

    static public Matrix mul(Matrix a, Matrix b) throws  Exception{
        double[][] mul = new double[a.getSizeY()][b.getSizeX()];

        double[][] a1 =a.matrix;
        double[][] b1 =b.matrix;

        if(a.getSizeX() != b.getSizeY()) throw new Exception("Количество столбцов матрицы 1 не равно кол-ву строчек матрицы 2");

        for(int i = 0; i < b.getSizeX(); i++){
            for(int j = 0; j < a.getSizeX(); j++){
                for(int k = 0; k < a.getSizeY(); k++){
                        mul[k][i] += a1[k][j] * b1[j][i];
                }
            }
        }
        return new Matrix(mul);
    }

    public void sum(Matrix b) throws Exception {//сумма 2 матриц возвращает значение в другой объект(при этом создание новой матрицы)

        if(this.getMatrix().length != b.getMatrix().length || this.getMatrix()[0].length != b.getMatrix()[0].length) throw new Exception("Матрицы разные");
        for(int i = 0; i < this.getMatrix().length; i++) for (int k = 0; k < this.getMatrix()[0].length; k++ ) this.matrix[i][k] += b.getMatrix()[i][k];
    }

    public void diff(Matrix b) throws Exception {//сумма 2 матриц возвращает значение в другой объект(при этом создание новой матрицы)

        if(this.getMatrix().length != b.getMatrix().length || this.getMatrix()[0].length != b.getMatrix()[0].length) throw new Exception("Матрицы разные");
        for(int i = 0; i < this.getMatrix().length; i++) for (int k = 0; k < this.getMatrix()[0].length; k++ ) this.matrix[i][k] -= b.getMatrix()[i][k];
    }

    public void mul(Matrix b) throws  Exception{
        double[][] newMatrix = new double[this.getSizeY()][b.getSizeX()];

        double[][] a1 =this.matrix;
        double[][] b1 =b.matrix;

        if(this.getSizeX() != b.getSizeY()) throw new Exception("Количество столбцов матрицы 1 не равно кол-ву строчек матрицы 2");

        for(int i = 0; i < b.getSizeX(); i++) {
            for (int j = 0; j < this.getSizeX(); j++) {
                for (int k = 0; k < this.getSizeY(); k++) {
                    newMatrix[k][i] += a1[k][j] * b1[j][i];
                }
            }
        }

        this.matrix = newMatrix;
    }

    public void print(){
        for(int i = 0; i < this.matrix.length; i++){
            for(int k = 0; k < this.matrix[0].length; k++) System.out.print(this.matrix[i][k] + " ");
            System.out.println();
        }
    }

    public void mul(double a){
        for(int i = 0; i < this.matrix.length; i++) for(int k = 0; k < this.matrix[0].length; k++) this.matrix[i][k] *= a;
    }

    public double[][] getMatrix(){ return matrix;}

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

}
