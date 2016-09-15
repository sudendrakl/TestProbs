import java.util.Hashtable;

/*
 *
 * Count the Clothes Visible
Problem Statement

 * The problem with the drying of clothes on the rope.
 The rope is small and all the clothes are not able to be spread out properly,
 Clothes are placed on top of other cloth.
 So some of the clothes are covered - partially or completely - by the other ones.
 Knowing the order and the position in which the clothes were hung, determine how many clothes are visible (partially or completely) when seen from front.

Consider the rope was of length N meters divided into N equal sections starting from 0 to N. Each cloth of width P occupies one or more than one section completely. (1<=P<=N & P is a +ve integer).
(Note: Ignore the other dimension of cloth for the purpose of this problem)

Input Specifications

Your program must read three arguments RopeLength, CountofClothes, ClothesPosition[] where
RopeLength is the length of the rope in meters (1<=RopeLength<=10000)
CountofClothes is the number of clothes which are placed on the rope (1<=CountofClothes<=10000)
ClothesPosition is an array giving the position in which the clothes were hung. The cloth position is described by two integers L and W, where L represents the start position of where the cloth was hung (0<=L<10000) and W is the width of the cloth (1<=W<=10000)

The order in which the input is received is the order in which the clothes are placed on the rope.

Output Specifications
Your function GetVisibleCount should set the output variable 'output1' to the count of clothes visible completely or partially.

Example

Sample input: 10:5:{{0,4},{6,3},{1,5},{6,4},{7,2}}
Here 10 is the length of the rope in meters. 5 is the number of clothes hung on rope. The first cloth starts from 0 and covers 4 sections from 0. The second cloth starts at 6 and covers 3 sections from 6 and so on..

Sample output: 4
The total number of clothes visible when seen from front is 4.
 *
 * */




    public class VisibleClothes {

      public int calculate(int input1, int input2, int[][] input3) {
        //Write code here
        int output1 = input2;

        int noOfClothes = input2;
        Hashtable<Integer, Integer> secDict = null;
        for (int i = 0; i < noOfClothes; i++) {
          int startValue = input3[i][0];
          int length = input3[i][1];
          int endValue = startValue + length;
          secDict = new Hashtable<Integer, Integer>();
          for (int k = startValue; k < endValue; k++) {
            secDict.put(k, k + 1);
          }

          //check if any cloth is hidden by later clothes
          for (int j = i + 1; j < noOfClothes; j++) {
            int startValueTemp = input3[j][0];
            int lengthTemp = input3[j][1];
            int endValueTemp = startValueTemp + lengthTemp;

            if ((startValueTemp >= startValue && startValueTemp < endValue) || (endValueTemp > startValue && endValueTemp <= endValue)) {
              //totally inside
              if (startValueTemp >= startValue && endValueTemp <= endValue) {
                for (int m = startValueTemp; m < endValueTemp; m++) {
                  if (secDict.get(m) != null) {
                    secDict.remove(m);
                  }
                }
              }
              //totally covering
              else if (startValueTemp < startValue && endValueTemp > endValue) {
                secDict.clear();
              }
              //starting later, ending later
              else if (startValueTemp >= startValue && endValueTemp >= endValue) {
                for (int m = startValueTemp; m < endValue; m++) {
                  if (secDict.get(m) != null) {
                    secDict.clear();
                  }
                }
              }
              //starting before, ending before
              else if (startValueTemp <= startValue && endValueTemp <= endValue) {
                for (int m = startValue; m < endValueTemp; m++) {
                  if (secDict.get(m) != null) {
                    secDict.clear();
                  }
                }
              }
            }
          }

          //check if dictionary has anything left
          if (secDict.size() == 0) {
            output1--;
          }
        }

        return output1;
      }
    }


