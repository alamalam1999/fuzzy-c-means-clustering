import java.util.Random;

public class fuzzy {


    public static void main( String [] args) {
        //input random bound and divide
        fuzzy a = new fuzzy();

        //inputColumnParameter
        //int iCP = 2;

        //inputKuadrat
        int weight = 2;

        double[][] parameter = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1}};
        //inputColumnParameter
        int iCP = parameter.length;
        //inputBarisParameter
        int iBP = parameter[1].length;
        //inputClusterTotal and inputTotalData must be same with BarisParameter
        //this is for randomMethod
        int iCT = 3;
        int iTD = iBP;
        double[][] parameterN = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1},{3,3,3,3,2,2,1,1}};


        //for Pusat Cluster / Cluster Center
        double[][] clusterCenter = new double[iCT][parameter[1].length];

        //for X_V
        double[][][] X_V = new double[parameter.length][iCT][parameter[1].length];

        //for X_V_BAWAH
        double[][] X_V_2 = new double[iCT][parameter[1].length];

        //for L
        double[][] L = new double[iCT][parameter[1].length];

        //for TOTAL L
        double[][] totalL = new double[1][parameter[1].length];

        //for Fungsi Objective
        double fungsiObjectif = 0.0;

        //for FO Iteration
        double fungsiObjectifIteration = 0.0;
        fungsiObjectifIteration = fungsiObjectifIteration - fungsiObjectif;

        //for LT
        double[][] LT = new double[iCT][parameter[1].length];

        //for TOTAL LT
        double[][] totalLT = new double[1][parameter[1].length];

        //for NEW MEMBER/KEANGGOTAAN BARU
        double[][] newMember = new double[iCT][parameter[1].length];

        //for TOTAL NEW MEMBER
        double[][] totalNewMember = new double[1][parameter[1].length];

        //total Random Value Rotate
        double[][] totalRandomValueRotate = new double[iCT][1];

        //inputIteration
        int inputIteration = 100;

        //Miu Kuadrat X1
        int iCT2 = iCT*iCP;

        //for result Total Total Miu Kuadrat X
        double[][] totalMiuKuadrat = new double[iCT2][1];

        //
        double [][] newMemberCluster= new double[iBP][iCT];

        double[][] miuKuadratX1 = new double[iCT2][iTD];

        int boundDivide = 10;
        //cluster total
        int clusterTotal = iCT;
        //total data do you hava
        int totalData = iBP;
        //divide x / totalCluster
        double[][] clusterResult = new double[totalData][clusterTotal];

        double[][] clusterRand = new double[clusterTotal][totalData];
        double[] clusterRandResult = new double[totalData];
        double[][] clusterMove = new double[totalData][clusterTotal];

        //Random value for cluster member
        Random rand = new Random();

        //System.out.println(clusterRandom);

        //double[][] randomValueCluster = clusterResult;

        //randomValueAfterPow
        double[][] randomValueAfterPow = new double[iTD][iCT];

        //
        double[][] randomValueRotate = new double[iCT][iTD];


        System.out.println("=====================================================================");

        for (int y = 0; y < clusterTotal; y++) {
            for(int j = 0; j < totalData; j++) {
                double valueRandom = rand.nextInt(boundDivide);
                double clusterRandom  = 0;
                clusterRandom = valueRandom / boundDivide;
                clusterRand[y][j] = clusterRandom;
                //System.out.print(clusterRand[y][j]+" ");
            }
            //System.out.println();
        }

        System.out.println("=====================================================================");

        for (int x = 0; x < clusterTotal; x++) {
            for (int j = 0; j < totalData; j++) {
                //clusterRandResult[j] = clusterRand[0][j]+clusterRand[1][j]+clusterRand[2][j];
                clusterMove[j][x] = clusterRand[x][j];
                //System.out.print(clusterMove[j][x]);
            }
            //System.out.println();
        }

        System.out.println("=====================================================================");

        for (int x = 0; x < totalData; x++) {
            for (int j = 0; j < clusterTotal; j++) {
                //System.out.print(clusterMove[x][j] +" ");
                clusterRandResult[x]= clusterRandResult[x] + clusterMove[x][j];
            }
            //System.out.println();
        }

        for (int x = 0; x < totalData; x++) {
            //System.out.println(clusterRandResult[x]);
        }

        System.out.println("========================clusterResult[x][j]=========================");

        for (int x = 0; x < totalData; x++) {
            for (int j = 0; j < clusterTotal; j++) {
                clusterResult[x][j] = clusterMove[x][j] / clusterRandResult[x];
                System.out.print(" |"+clusterResult[x][j]);
            }
            System.out.println();
        }


        System.out.println("=====================PARAMETER=======================");

        for (int x = 0; x < iCP; x++) {
            for (int j = 0; j < iBP; j++) {
                System.out.print(parameter[x][j] + " ");
            }
            System.out.println();
        }


       for (int iteration = 0; iteration < inputIteration;iteration++) {

           double difference = fungsiObjectif;

           System.out.println("=====================POW=======================");

           for (int x = 0; x < iTD; x++) {
               for (int j = 0; j < iCT; j++) {
                   randomValueAfterPow[x][j] = Math.pow(clusterResult[x][j], weight);
                   System.out.println(" |" + randomValueAfterPow[x][j]);
               }
               System.out.println();
           }

           System.out.println("======================rotate=====================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < iTD; j++) {
                   randomValueRotate[x][j] = randomValueAfterPow[j][x];
                   System.out.print(randomValueRotate[x][j] + "|");
               }
               System.out.println();
           }

           System.out.println("=================Result Total Miu Kuadrat====================");

           int y = 0;
           int z = 0;

           int batas = iCP;
           for (int x = 0; x < iCT2; x++) {
               if (x % batas == 0) {
                   z = 0;
               } else if (x > 0) {
                   z++;
               }

               if (x % batas == 0 && x > 0) {
                   y++;
               }
               for (int j = 0; j < parameter[1].length; j++) {
                   miuKuadratX1[x][j] = randomValueRotate[y][j] * parameter[z][j];
                   System.out.print(miuKuadratX1[x][j]);
               }
               System.out.println();
           }

           System.out.println("===================totalRandomValueRotate=====================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < iTD; j++) {
                   totalRandomValueRotate[x][0] = 0;
                   //System.out.println("| x = " + x + " j = " + j + " " + totalRandomValueRotate[x][0]);
               }
               System.out.print("==============");
           }

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < iTD; j++) {
                   totalRandomValueRotate[x][0] += randomValueRotate[x][j];
                   System.out.println("| x = " + x + " j = " + j + " " + totalRandomValueRotate[x][0]);
               }
               System.out.print("==============");
           }


           System.out.println("====================== result Total Total Miu Kuadrat X ==========================");

           //netralization
           for (int x = 0; x < iCT2; x++) {
               for (int j = 0; j < iTD; j++) {
                   totalMiuKuadrat[x][0] = 0;
                   //System.out.println("| x = " + x + " j = " + j + " totalMiuKuadrat X =" + totalMiuKuadrat[x][0]);
               }
               System.out.print("===============");
           }

           for (int x = 0; x < iCT2; x++) {
               for (int j = 0; j < iTD; j++) {

                   totalMiuKuadrat[x][0] += miuKuadratX1[x][j];

                   System.out.println("| x = " + x + " j = " + j + " totalMiuKuadrat X =" + totalMiuKuadrat[x][0]);
               }
               System.out.print("===============");
           }

           System.out.println("=====================Pusat Cluster/Cluster Center===================");

           System.out.println(parameter.length + " " + parameter[0].length + " " + parameter[1].length);

           int yy = 0;
           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter.length; j++) {
                   clusterCenter[x][j] = totalMiuKuadrat[yy][0] / totalRandomValueRotate[x][0];
                   System.out.println("| x = " + x + " j = " + j + " y = " + yy + "| center =" + clusterCenter[x][j]);
                   yy++;
               }
               System.out.println();
           }

           System.out.println("================================X_V================================");
           //int weight = 2;
           for (int yx = 0; yx < parameter.length; yx++) {
               for (int x = 0; x < iCT; x++) {
                   for (int j = 0; j < parameter[1].length; j++) {
                       X_V[yx][x][j] = Math.pow((parameter[yx][j] - clusterCenter[x][yx]), 2);//must be check use weight or just use value 2
                       System.out.println("X_V[" + yx + "][" + x + "][" + j + "] = " + X_V[yx][x][j]);
                   }
                   System.out.println();
               }
               System.out.println();
           }

           System.out.println("==================================X_V_BAWAH=========================================");

           //netralization
           for (int yj = 0; yj < parameter.length; yj++) {
               for (int x = 0; x < iCT; x++) {
                   for (int j = 0; j < parameter[1].length; j++) {
                       X_V_2[x][j] = 0;
                       //System.out.println("X_V[" + yj + "][" + x + "][" + j + "] = " + X_V_2[x][j]);
                   }
                   System.out.println();
               }
               System.out.println();
           }

           for (int yj = 0; yj < parameter.length; yj++) {
               for (int x = 0; x < iCT; x++) {
                   for (int j = 0; j < parameter[1].length; j++) {
                       X_V_2[x][j] += X_V[yj][x][j];
                       System.out.println("X_V[" + yj + "][" + x + "][" + j + "] = " + X_V_2[x][j]);
                   }
                   System.out.println();
               }
               System.out.println();
           }

           System.out.println("================================total result from X_V_2=======================================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   System.out.println("X_V[" + x + "][" + j + "] = " + X_V_2[x][j]);
               }
               System.out.println();
           }

           System.out.println("==============================L===============================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   L[x][j] = X_V_2[x][j] * randomValueRotate[x][j];
                   System.out.println(" L[" + x + "][" + j + "] " + L[x][j]);
               }
               System.out.println();
           }

           System.out.println("===========================TOTAL L==========================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   totalL[0][j] = 0;
                   //System.out.println("TOTAL L =" + totalL[0][j]);
               }
               System.out.println();
           }

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   totalL[0][j] += L[x][j];
                   System.out.println("TOTAL L =" + totalL[0][j]);
               }
               System.out.println();
           }

           System.out.println("=======================Fungsi Objective=======================");
            //netralization function objectif
           for (int x = 0; x < parameter[1].length; x++) {
               fungsiObjectif = 0;
               //System.out.println("fungsi objectif = " + fungsiObjectif);
           }

           for (int x = 0; x < parameter[1].length; x++) {
               fungsiObjectif += totalL[0][x];
               System.out.println("fungsi objectif = " + fungsiObjectif);
           }

           System.out.println("difference = "+Math.abs(fungsiObjectif-difference));

           System.out.println("==============================LT==============================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   LT[x][j] = Math.pow(X_V_2[x][j], (-1 / (weight - 1)));
                   //LT[x][j] = Math.pow(L[x][j],(-1/(weight-1)));
                   System.out.println("LT = " + LT[x][j]);
               }
               System.out.println();
           }

           System.out.println("=============================TOTAL LT============================");
            //Netralization
           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   totalLT[0][j] = 0;
                   //System.out.println(" total L = " + totalLT[0][j]);
               }
               System.out.println();
           }

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   totalLT[0][j] += LT[x][j];
                   System.out.println(" total L = " + totalLT[0][j]);
               }
               System.out.println();
           }

           System.out.println("=============================NEW MEMBER/KEANGGOTAAN BARU==============================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   newMember[x][j] = LT[x][j] / totalLT[0][j];

                   System.out.println("new Member = " + newMember[x][j]);
               }
               System.out.println();
           }

           System.out.println("=============================NEW MEMBER ROTATE==============================");

           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   clusterResult[j][x] = newMember[x][j];
                   System.out.println("new Member = " + newMember[x][j]);
               }
               System.out.println();
           }

           System.out.println("============================TOTAL NEW MEMBER==========================");

           System.out.println("process netralitization to zero");
           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {totalNewMember[0][j] = 0;}
               System.out.println();
           }


           for (int x = 0; x < iCT; x++) {
               for (int j = 0; j < parameter[1].length; j++) {
                   totalNewMember[0][j] += newMember[x][j];

                   System.out.println("totalNewMember = " + totalNewMember[0][j]);
               }
               System.out.println();
           }

       }
    }
}
