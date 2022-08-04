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


    public double[][] miuKuadratX1(int iCP,int iBP,double parameter[][],int iTD,int iCT,int weight) {

        fuzzy a = new fuzzy();
        //result from method random value cluster to equals 1
        double[][] randomValueCluster = a.randomValueCluster(iCT,iTD);

        //randomValueAfterPow
        double[][] randomValueAfterPow = new double[iTD][iCT];

        //
        double[][] randomValueRotate = new double[iCT][iTD];

        //Miu Kuadrat X1
        int iCT2 = iCT*2;
        double[][] miuKuadratX1 = new double[iCT2][iTD];
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

        System.out.println("");
        for (int x = 0; x < iCT; x++) {
            for (int j = 0; j < iTD; j++) {
                randomValueRotate[x][j] = randomValueAfterPow[j][x];

                System.out.print(randomValueRotate[x][j] +"|");
            }
            System.out.println();
        }

        System.out.println("=================Result Total Miu Kuadrat====================");


        int y = 0;
        int z = 0;
        for (int x = 0; x < iCT2; x++) {
            if (x%2==1) { z = 1;
            } else { z = 0; }

            if (x%2==0 && x>0){
                y++;
            }
            for (int j = 0; j < iTD; j++) {
                miuKuadratX1[x][j] = randomValueRotate[y][j] * parameter[z][j];
                /*miuKuadratX1[1][j] = randomValueRotate[0][j] * parameter[1][j];
                miuKuadratX1[2][j] = randomValueRotate[1][j] * parameter[0][j];
                miuKuadratX1[3][j] = randomValueRotate[1][j] * parameter[1][j];
                miuKuadratX1[4][j] = randomValueRotate[2][j] * parameter[0][j];
                miuKuadratX1[5][j] = randomValueRotate[2][j] * parameter[1][j];*/
                /*      System.out.println("x = "+x+" y = "+y+ " z = "+z+" j = "+j);*/
            }
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
        int iCP = 2;
        //inputBarisParameter
        int iBP = 8;
        //inputKuadrat
        int weight = 2;

        //inputClusterTotal and inputTotalData must be same with BarisParameter
        //this is for randomMethod
        int iCT = 3;
        int iTD = iBP;

        double[][] parameter = {{1,3,4,5,1,4,1,2},{3,3,3,3,2,2,1,1}};

        //result from method random value cluster to equals 1
        double[][] randomValueCluster = a.randomValueCluster(iCT,iTD);

        //randomValueAfterPow
        double[][] randomValueAfterPow = new double[iTD][iCT];
        //
        double[][] randomValueRotate = new double[iCT][iTD];

        //Miu Kuadrat X1
        int iCT2 = iCT*2;
        double[][] miuKuadratX1 = new double[iCT2][iTD];

        //Total Miu Kuadrat
        int totalElement = 1;
        double[][] totalMiuKuadrat = new double[iCT2][totalElement];

        miuKuadratX1 = a.miuKuadratX1(iCP,iBP,parameter,iTD,iCT, weight);

        System.out.println("====================== result Total Total Miu Kuadrat X ==========================");
        for (int x = 0; x < iCT2; x++) {
            for (int j = 0; j < iTD; j++) {

                totalMiuKuadrat[x][0]+=miuKuadratX1[x][j];

                System.out.println("| x = "+x+" j = "+j+" totalMiuKuadrat X" +totalMiuKuadrat[x][0]);
            }
            System.out.print("===============");
        }
    }


}
