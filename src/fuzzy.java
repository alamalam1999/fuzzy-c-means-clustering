import java.util.Random;

public class fuzzy {


    public double[][] randomValueCluster(int inputClusterTotal,int inputTotalData) {
        int boundDivide = 10;
        //cluster total
        int clusterTotal = inputClusterTotal;
        //total data do you hava
        int totalData = inputTotalData;
        //divide x / totalCluster
        double[][] clusterResult = new double[totalData][clusterTotal];

        double[][] clusterRand = new double[clusterTotal][totalData];
        double[] clusterRandResult = new double[totalData];
        double[][] clusterMove = new double[totalData][clusterTotal];

        //Random value for cluster member
        Random rand = new Random();

        //System.out.println(clusterRandom);

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

        System.out.println("==========================================================");

        for (int x = 0; x < totalData; x++) {
            for (int j = 0; j < clusterTotal; j++) {
                clusterResult[x][j] = clusterMove[x][j] / clusterRandResult[x];

                //System.out.print(clusterResult[x][j]+" ");
            }
            //System.out.println();
        }

        return clusterResult;
    }

    //randomValueRotateAfterPow
    public double[][] randomValueRotateAfterPow(int iCT,int iBP,int iCP, double parameter[][],int iTD,int weight) {
        fuzzy a = new fuzzy();
        //result from method random value cluster to equals 1
        double[][] randomValueCluster = a.randomValueCluster(iCT,iTD);

        //randomValueAfterPow
        double[][] randomValueAfterPow = new double[iTD][iCT];

        //
        double[][] randomValueRotate = new double[iCT][iTD];


        System.out.println("=====================PARAMETER=======================");

        for (int x = 0; x < iCP; x++) {
            for (int j = 0; j < iBP; j++) {
                System.out.print(parameter[x][j] + " ");
            }
            System.out.println();
        }

        System.out.println("=====================POW=======================");

        for (int x = 0; x < iTD; x++) {
            for (int j = 0; j < iCT; j++) {
                randomValueAfterPow[x][j] = Math.pow(randomValueCluster[x][j],weight);
                //System.out.print(randomValueCluster[x][j]+"|");
                //System.out.print(randomValueAfterPow[x][j] +"|");
            }
            // System.out.println();
        }

        System.out.println("======================rotate=====================");
        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < iTD; j++) {
                randomValueRotate[x][j] = randomValueAfterPow[j][x];
                System.out.print(randomValueRotate[x][j] +"|");
            }
            System.out.println();
        }

        return randomValueRotate;
    }


    public double[][] miuKuadratX1(int iCP,int iBP,double parameter[][],int iTD,int iCT,int weight) {

        fuzzy a = new fuzzy();

        //Miu Kuadrat X1
        int iCT2 = iCT*iCP;
        double[][] miuKuadratX1 = new double[iCT2][iTD];


        //        double[][] randomValueRotate = new double[iCT][iTD];
        double[][] randomValueRotate = a.randomValueRotateAfterPow(iCT,iBP,iCP,parameter,iTD,weight);

        System.out.println("=================Result Total Miu Kuadrat====================");

        int y = 0;
        int z = 0;

        int batas = iCP;
        for (int x = 0; x < iCT2; x++) {
            if (x%batas==0) { z = 0;
            } else if(x>0){ z++; }

            if (x%batas==0 && x>0){
                y++;
            }
            for (int j = 0; j < parameter[1].length; j++) {
                miuKuadratX1[x][j] = randomValueRotate[y][j] * parameter[z][j];
                /*miuKuadratX1[1][j] = randomValueRotate[0][j] * parameter[1][j];
                miuKuadratX1[2][j] = randomValueRotate[1][j] * parameter[0][j];
                miuKuadratX1[3][j] = randomValueRotate[1][j] * parameter[1][j];
                miuKuadratX1[4][j] = randomValueRotate[2][j] * parameter[0][j];
                miuKuadratX1[5][j] = randomValueRotate[2][j] * parameter[1][j];*/
                //System.out.println("x = "+x+" y = "+y+ " z = "+z+" j = "+j);
                System.out.print(miuKuadratX1[x][j]);
            }
            System.out.println();
        }

        System.out.println("===============================miuKuadratX1=============================");

        for (int x = 0; x < iCT2; x++) {
            for (int j = 0; j < iTD; j++) {
                System.out.print(miuKuadratX1[x][j] +"|");
            }
            System.out.println();
        }

        return miuKuadratX1;
    }

    public static void main( String [] args) {
        //input random bound and divide
        fuzzy a = new fuzzy();

        //inputColumnParameter
        //int iCP = 2;
        //inputBarisParameter
        int iBP = 8;
        //inputKuadrat
        int weight = 2;

        //inputClusterTotal and inputTotalData must be same with BarisParameter
        //this is for randomMethod
        int iCT = 3;
        int iTD = iBP;

        double[][] parameter = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1}};
        //inputColumnParameter
        int iCP = parameter.length;
        double[][] parameterN = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1},{3,3,3,3,2,2,1,1}};

        double[][] randomValueRotate = a.randomValueRotateAfterPow(iCT,iBP,iCP,parameter,iTD,weight);

        System.out.println("===================totalRandomValueRotate=====================");
        int elementTotal = 1;
        double[][] totalRandomValueRotate = new double[iCT][elementTotal];

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < iTD; j++) {
                totalRandomValueRotate[x][0] += randomValueRotate[x][j];
                System.out.println("| x = "+x+" j = "+j+" "+totalRandomValueRotate[x][0]);
            }
            System.out.print("==============");
        }

        //Miu Kuadrat X1
        int iCT2 = iCT*iCP;
        double[][] miuKuadratX1 = new double[iCT2][iTD];

        //Total Miu Kuadrat
        int totalElement = 1;

        //for result Total Total Miu Kuadrat X
        double[][] totalMiuKuadrat = new double[iCT2][totalElement];

        miuKuadratX1 = a.miuKuadratX1(iCP,iBP,parameter,iTD,iCT,weight);

        System.out.println("====================== result Total Total Miu Kuadrat X ==========================");
        for (int x = 0; x < iCT2; x++) {
            for (int j = 0; j < iTD; j++) {

                totalMiuKuadrat[x][0]+=miuKuadratX1[x][j];

                System.out.println("| x = "+x+" j = "+j+" totalMiuKuadrat X =" +totalMiuKuadrat[x][0]);
            }
            System.out.print("===============");
        }


        System.out.println("=====================Pusat Cluster/Cluster Center===================");

        //for Pusat Cluster / Cluster Center
        double[][] clusterCenter = new double[iCT][parameter[1].length];

        System.out.println(parameter.length+" "+parameter[0].length+" "+parameter[1].length);

        int yy = 0;
        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter.length; j++) {
                clusterCenter[x][j] =  totalMiuKuadrat[yy][0] / totalRandomValueRotate[x][0];
              /*  clusterCenter[0][1] =  totalMiuKuadrat[1][0] / totalRandomValueRotate[0][0];
                clusterCenter[1][0] =  totalMiuKuadrat[2][0] / totalRandomValueRotate[1][0];
                clusterCenter[1][1] =  totalMiuKuadrat[3][0] / totalRandomValueRotate[1][0];
                clusterCenter[2][0] =  totalMiuKuadrat[4][0] / totalRandomValueRotate[2][0];
                clusterCenter[2][1] =  totalMiuKuadrat[5][0] / totalRandomValueRotate[2][0];*/
                System.out.println("| x = "+x+" j = "+j+ " y = "+yy+"| center =" + clusterCenter[x][j]);
                yy++;
            }
            System.out.println();
        }



        System.out.println("================================X_V================================");

        //for X_V
        double[][][] X_V = new double[parameter.length][iCT][parameter[1].length];
        //int weight = 2;

        for (int y = 0; y < parameter.length; y++) {
            for (int x = 0; x < iCT; x++) {
                for (int j = 0; j < parameter[1].length; j++) {
                    X_V[y][x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),weight);

                    //X_V[0][0][0] = Math.pow((parameter[0][0] - clusterCenter[0][0]),weight);
                    //X_V[0][0][1] = Math.pow((parameter[0][1] - clusterCenter[0][0]),weight);
                    //X_V[0][0][2] = Math.pow((parameter[0][2] - clusterCenter[0][0]),weight);
                    //X_V[0][0][3] = Math.pow((parameter[0][3] - clusterCenter[0][0]),weight);
                    //X_V[0][0][4] = Math.pow((parameter[0][4] - clusterCenter[0][0]),weight);
                    //X_V[0][0][5] = Math.pow((parameter[0][5] - clusterCenter[0][0]),weight);
                    //X_V[0][0][6] = Math.pow((parameter[0][6] - clusterCenter[0][0]),weight);
                    //X_V[0][0][7] = Math.pow((parameter[0][7] - clusterCenter[0][0]),weight);
                    //X_V[0][0][8] = Math.pow((parameter[0][8] - clusterCenter[0][0]),weight);



                    //X_V[0][1][0] = Math.pow((parameter[0][0] - clusterCenter[1][0]),weight);
                    //X_V[0][1][1] = Math.pow((parameter[0][1] - clusterCenter[1][0]),weight);
                    //X_V[0][1][2] = Math.pow((parameter[0][2] - clusterCenter[1][0]),weight);
                    //X_V[0][1][3] = Math.pow((parameter[0][3] - clusterCenter[1][0]),weight);
                    //X_V[0][1][4] = Math.pow((parameter[0][4] - clusterCenter[1][0]),weight);
                    //X_V[0][1][5] = Math.pow((parameter[0][5] - clusterCenter[1][0]),weight);
                    //X_V[0][1][6] = Math.pow((parameter[0][6] - clusterCenter[1][0]),weight);
                    //X_V[0][1][7] = Math.pow((parameter[0][7] - clusterCenter[1][0]),weight);
                    //X_V[0][1][8] = Math.pow((parameter[0][8] - clusterCenter[1][0]),weight);

                    /*X_V[x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),weight)+Math.pow((parameter[1][j] - clusterCenter[x][1]),weight);
                    X_V[1][j] = Math.pow((parameter[0][j] - clusterCenter[1][0]),weight)+Math.pow((parameter[1][j] - clusterCenter[1][1]),weight);
                    X_V[2][j] = Math.pow((parameter[0][j] - clusterCenter[2][0]),weight)+Math.pow((parameter[1][j] - clusterCenter[2][1]),weight);*/

                    System.out.println("X_V["+ y +"]["+ x +"]["+ j +"] = "+X_V[y][x][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("==================================X_V_BAWAH=========================================");

        //for X_V_BAWAH
        double[][] X_V_2 = new double[iCT][parameter[1].length];

        for (int y = 0; y < parameter.length; y++) {
            for (int x = 0; x < iCT; x++) {
                for (int j = 0; j < parameter[1].length; j++) {
                    X_V_2[x][j] += X_V[y][x][j];

                    System.out.println("X_V["+ y +"]["+ x +"]["+ j +"] = "+X_V_2[x][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        System.out.println("================================total result from X_V_2=======================================");

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                System.out.println("X_V["+ x +"]["+ j +"] = "+X_V_2[x][j]);
            }
            System.out.println();
        }

        System.out.println("==============================L===============================");

        //double[][] randomValueRotate = a.randomValueRotateAfterPow(iCT,iBP,iCP,parameter,iTD,weight);

        //for L
        double[][] L = new double[iCT][parameter[1].length];


        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                L[x][j] = X_V_2[x][j] * randomValueRotate[x][j];
                System.out.println(" L["+x+"]["+j+"] "+L[x][j]);
            }
            System.out.println();
        }

        System.out.println("===========================TOTAL L==========================");

        //for TOTAL L
        double[][] totalL = new double[1][parameter[1].length];

        for (int x = 0;x < iCT;x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                totalL[0][j] += L[x][j];
                System.out.println("TOTAL L ="+totalL[0][j]);
            }
            System.out.println();
        }


        System.out.println("=======================Fungsi Objective=======================");

        //for Fungsi Objective
        double fungsiObjectif = 0.0;

        for (int x = 0;x < parameter[1].length;x++) {
           fungsiObjectif += totalL[0][x];
            System.out.println("fungsi objectif = "+fungsiObjectif);
        }

        System.out.println("==============================LT==============================");

        //for LT
        double[][] LT = new double[iCT][parameter[1].length];

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                LT[x][j] = Math.round(Math.pow(L[x][j],(-1/(weight-1))));

                System.out.println("LT = "+LT[x][j]);
            }
            System.out.println();
        }

        System.out.println("=============================TOTAL LT============================");

        //for TOTAL LT
        double[][] totalLT = new double[1][parameter[1].length];

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                totalLT[0][j] += LT[x][j];
                System.out.println(" total L = "+totalLT[0][j]);
            }
            System.out.println();
        }


        System.out.println("=============================NEW MEMBER/KEANGGOTAAN BARU==============================");

        //for NEW MEMBER/KEANGGOTAAN BARU
        double[][] newMember = new double[iCT][parameter[1].length];

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                newMember[x][j] = LT[x][j] / totalLT[0][j];

                System.out.println("new Member = "+ newMember[x][j]);
            }
            System.out.println();
        }

        System.out.println("============================TOTAL NEW MEMBER==========================");

        //for TOTAL NEW MEMBER
        double[][] totalNewMember = new double[1][parameter[1].length];

        for (int x = 0 ; x < iCT; x++) {
            for (int j =  0; j < parameter[1].length; j++) {
                totalNewMember[0][j] += newMember[x][j];

                System.out.println("totalNewMember = "+totalNewMember[0][j]);
            }
            System.out.println();
        }


    }










}
