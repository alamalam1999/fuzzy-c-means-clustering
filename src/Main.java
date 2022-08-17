public class Main {
    public static void main (String [] args) {
      /*  int z = 3;

        if (z%2==1) {
            System.out.println(z);
        }

*/

       /* int y = 0;
        int z = 0;

        int batas = 3;
        for (int x = 0; x < 9; x++) {
            if (x%batas==0) { z = 0;
            } else if(x>0){ z++; }

            if (x%batas==0 && x>0){
                y++;
            }
            for (int j = 0; j < 9; j++) {
                //miuKuadratX1[x][j] = randomValueRotate[y][j] * parameter[z][j];
                *//*miuKuadratX1[1][j] = randomValueRotate[0][j] * parameter[1][j];
                miuKuadratX1[2][j] = randomValueRotate[1][j] * parameter[0][j];
                miuKuadratX1[3][j] = randomValueRotate[1][j] * parameter[1][j];
                miuKuadratX1[4][j] = randomValueRotate[2][j] * parameter[0][j];
                miuKuadratX1[5][j] = randomValueRotate[2][j] * parameter[1][j];*//*
                System.out.println("x = "+x+" y = "+y+ " z = "+z+" j = "+j);
            }

        }
    }*/
       /* double[][] parameter = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1},{3,3,3,3,2,2,1,1}};

        double[][] clusterCenter = {{3.40991807754292,2.33574147612847,2.33574147612847},{1.34179859453818,1.50833234579143,1.50833234579143},{5.00515195226415,3.88937578414276,3.88937578414276}};

        double[][][] X_V = new double[3][3][8];



        int weight = 2;

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                for (int j = 0; j < 8; j++) {
                    X_V[y][x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),weight);
                    //X_V[y][x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),weight);
                    *//*X_V[x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),weight)+Math.pow((parameter[1][j] - clusterCenter[x][1]),weight);
                    X_V[1][j] = Math.pow((parameter[0][j] - clusterCenter[1][0]),weight)+Math.pow((parameter[1][j] - clusterCenter[1][1]),weight);
                    X_V[2][j] = Math.pow((parameter[0][j] - clusterCenter[2][0]),weight)+Math.pow((parameter[1][j] - clusterCenter[2][1]),weight);*//*
                    System.out.println("X_V["+ y +"]["+ x +"]["+ j +"] = "+X_V[y][x][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("===========================================================================");

        double[][] X_V_2 = new double[3][8];

        for (int y = 0; y < 2; y++) {
            for (int x = 0; x < 3; x++) {
                for (int j = 0; j < 8; j++) {
                    X_V_2[x][j] += X_V[y][x][j];

                    System.out.println("X_V["+ y +"]["+ x +"]["+ j +"] = "+X_V_2[x][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        System.out.println("================================total result from X_V_2=======================================");

        for (int x = 0; x < 3; x++) {
            for (int j = 0; j < 8; j++) {
                System.out.println("X_V["+ x +"]["+ j +"] = "+X_V_2[x][j]);
            }
            System.out.println();
        }*/



  /*  for (int x = 0; x < iCT2; x++) {
        int y = 0;
        int z = 0;
        for (int j = 0; j < iTD; j++) {
            if (x%2==1) { z = 1;
            } else { z = 0; }
            miuKuadratX1[x][j] = randomValueRotate[y][j] * parameter[z][j];

        }
        if (x%2==0){
            y = y+1;
        }
    }*/



    /*for (int j = 0; j < iTD; j++) {
                            miuKuadratX1[0][j] = randomValueRotate[0][j] * parameter[0][j];
                            miuKuadratX1[1][j] = randomValueRotate[0][j] * parameter[1][j];
                            miuKuadratX1[2][j] = randomValueRotate[1][j] * parameter[0][j];
                            miuKuadratX1[3][j] = randomValueRotate[1][j] * parameter[1][j];
                            miuKuadratX1[4][j] = randomValueRotate[2][j] * parameter[0][j];
                            miuKuadratX1[5][j] = randomValueRotate[2][j] * parameter[1][j];
                        }*/


    }
}
