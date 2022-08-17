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

    public double[][] miuKuadratUntilProcessNewMember(int iCP,int iBP,double parameter[][],int iTD,int iCT,int weight,double totalRandomValueRotate[][],
                                                       double randomValueRotate[][],double totalMiuKuadrat[][], double clusterCenter[][],int iCT2,
                                                       double X_V[][][],double X_V_2[][],double L[][],double totalL[][],double fungsiObjectif,
                                                       double LT[][],double totalLT[][],double newMember[][],double totalNewMember[][]) {

        fuzzy a = new fuzzy();

        double[][] miuKuadratX1 = a.miuKuadratX1(iCP,iBP,parameter,iTD,iCT,weight);

        System.out.println("===================totalRandomValueRotate=====================");

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < iTD; j++) {
                totalRandomValueRotate[x][0] += randomValueRotate[x][j];
                System.out.println("| x = "+x+" j = "+j+" "+totalRandomValueRotate[x][0]);
            }
            System.out.print("==============");
        }


        System.out.println("====================== result Total Total Miu Kuadrat X ==========================");
        for (int x = 0; x < iCT2; x++) {
            for (int j = 0; j < iTD; j++) {

                totalMiuKuadrat[x][0]+=miuKuadratX1[x][j];

                System.out.println("| x = "+x+" j = "+j+" totalMiuKuadrat X =" +totalMiuKuadrat[x][0]);
            }
            System.out.print("===============");
        }

        System.out.println("=====================Pusat Cluster/Cluster Center===================");

        System.out.println(parameter.length+" "+parameter[0].length+" "+parameter[1].length);

        int yy = 0;
        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter.length; j++) {
                clusterCenter[x][j] =  totalMiuKuadrat[yy][0] / totalRandomValueRotate[x][0];
                System.out.println("| x = "+x+" j = "+j+ " y = "+yy+"| center =" + clusterCenter[x][j]);
                yy++;
            }
            System.out.println();
        }

        System.out.println("================================X_V================================");

        //int weight = 2;

        for (int y = 0; y < parameter.length; y++) {
            for (int x = 0; x < iCT; x++) {
                for (int j = 0; j < parameter[1].length; j++) {
                    X_V[y][x][j] = Math.pow((parameter[y][j] - clusterCenter[x][y]),2);//must be check use weight or just use value 2
                    System.out.println("X_V["+ y +"]["+ x +"]["+ j +"] = "+X_V[y][x][j]);
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("==================================X_V_BAWAH=========================================");


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

        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                L[x][j] = X_V_2[x][j] * randomValueRotate[x][j];
                System.out.println(" L["+x+"]["+j+"] "+L[x][j]);
            }
            System.out.println();
        }

        System.out.println("===========================TOTAL L==========================");


        for (int x = 0;x < iCT;x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                totalL[0][j] += L[x][j];
                System.out.println("TOTAL L ="+totalL[0][j]);
            }
            System.out.println();
        }


        System.out.println("=======================Fungsi Objective=======================");



        for (int x = 0;x < parameter[1].length;x++) {
            fungsiObjectif += totalL[0][x];
            System.out.println("fungsi objectif = "+fungsiObjectif);
        }

        System.out.println("==============================LT==============================");



        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                LT[x][j] = Math.round(Math.pow(L[x][j],(-1/(weight-1))));

                System.out.println("LT = "+LT[x][j]);
            }
            System.out.println();
        }

        System.out.println("=============================TOTAL LT============================");


        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                totalLT[0][j] += LT[x][j];
                System.out.println(" total L = "+totalLT[0][j]);
            }
            System.out.println();
        }


        System.out.println("=============================NEW MEMBER/KEANGGOTAAN BARU==============================");


        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < parameter[1].length; j++) {
                newMember[x][j] = LT[x][j] / totalLT[0][j];

                System.out.println("new Member = "+ newMember[x][j]);
            }
            System.out.println();
        }

        System.out.println("============================TOTAL NEW MEMBER==========================");

        for (int x = 0 ; x < iCT; x++) {
            for (int j =  0; j < parameter[1].length; j++) {
                totalNewMember[0][j] += newMember[x][j];

                System.out.println("totalNewMember = "+totalNewMember[0][j]);
            }
            System.out.println();
        }

        return newMember;
    }


    public static void main( String [] args) {
        //input random bound and divide
        fuzzy a = new fuzzy();

        //inputColumnParameter
        //int iCP = 2;

        //inputKuadrat
        int weight = 2;

        double[][] parameter = {{1,3,4,5,1,4,1,2,4},{3,3,3,3,2,2,1,1,4}};
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
        int inputIteration = 3;

        //Miu Kuadrat X1
        int iCT2 = iCT*iCP;

        //for result Total Total Miu Kuadrat X
        double[][] totalMiuKuadrat = new double[iCT2][1];

        //
        double [][] clusterMove = new double[iBP][iCT];

        double[][] randomValueRotate = a.randomValueRotateAfterPow(iCT,iBP,iCP,parameter,iTD,weight);



        double[][] newMemberIteration = a.miuKuadratUntilProcessNewMember(iCP,iBP,parameter,iTD,iCT,weight,totalRandomValueRotate,
                randomValueRotate,totalMiuKuadrat,clusterCenter,iCT2,
                X_V,X_V_2,L,totalL,fungsiObjectif, LT,totalLT,newMember,totalNewMember);



    }
}
