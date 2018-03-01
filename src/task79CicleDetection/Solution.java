package task79CicleDetection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        String[] data = {
                "19 N-V U-V I-V J-I A-N O-J F-U C-A Z-F X-J K-N R-A D-X T-O P-X E-K S-A G-S M-J",
                "23 S-G P-S T-P J-G Y-J W-J O-J M-P Z-P N-P A-N U-M Q-W L-M V-P C-M H-T I-G F-Q R-L D-P K-L K-N",
                "17 I-E A-E V-E T-A N-A F-E U-V P-I G-P M-U O-G S-P W-P J-N X-U R-P X-M",
                "10 M-T C-T V-C Z-T E-Z F-M H-F O-Z Q-O Q-Z",
                "12 Y-Z S-Y C-Z T-Y D-Z N-S Q-Z J-T F-D U-Q M-S T-Q",
                "23 R-I B-R G-B V-B P-B M-R Q-P J-V N-B S-J O-Q W-N A-Q K-B H-R D-B F-R L-J E-J C-O Y-H X-I H-C",
                "17 E-W Y-W S-W J-E A-W X-E K-W G-Y Q-X T-S D-J L-A C-A Z-A N-C M-N W-E",
                "20 S-U J-S N-S A-N Y-A B-A O-B L-B D-N V-Y K-B Q-Y T-Q R-Y G-B W-O P-T I-N F-N M-O",
                "11 R-I F-R X-R M-F S-R L-F G-L Y-S J-F A-M L-I",
                "13 L-I A-I F-I Z-A G-L X-G E-A Q-X S-Z H-S Y-E B-Y S-L",
                "7 U-V W-V J-W B-J N-V E-W B-E",
                "16 S-I K-I N-I B-I D-S O-I C-I W-S M-K Q-N F-O L-I U-I V-K Z-V N-S",
                "9 W-T X-W I-T U-W P-U Y-P G-W S-Y C-P",
                "18 I-G C-G X-I A-X W-X Z-I R-A H-X O-R S-G N-C F-I Y-N T-Z L-W U-C E-O I-Z",
                "9 C-F V-F R-F G-V K-V E-R Z-G P-E Y-P",
                "10 E-W H-W Q-W J-Q M-H K-Q L-W F-H T-W H-K",
                "21 Z-H V-H D-Z B-H X-H F-H I-F G-V Y-D Q-V E-F P-Q L-Q J-Y R-Y C-X W-C O-D T-D N-Z X-W",
                "17 I-E J-E P-E H-E O-E R-J L-J N-R Q-J Y-P A-E S-H C-H D-I X-C G-A K-R",
                "19 H-N Y-N C-H S-C J-S E-S A-C O-H G-A X-J U-N W-G K-U T-Y F-C L-W Z-A B-E Z-W",
                "17 Z-N D-Z M-N J-M L-D B-D S-D H-N C-B P-Z U-L Q-L K-B Y-L T-Y O-B T-M",
                "11 W-G Z-G B-Z A-W L-B K-Z R-K V-W J-W N-J P-R",
                "19 W-F G-F U-G V-U H-W C-F L-H R-C Z-V D-H E-L N-D A-W B-R X-D Q-F S-B Y-S N-V",
                "16 D-A T-A J-D I-D X-D Q-J V-Q H-D E-D F-H K-Q P-H O-E L-O G-O U-L",
                "18 P-Q O-Q I-P V-I F-I M-O S-F W-M L-P U-S K-S E-S N-I T-E D-S G-F J-Q P-J",
                "22 C-E S-E H-C X-S Q-C D-E L-E Y-Q M-S R-C F-H Z-C V-S U-C K-H B-K T-U P-M G-X N-Q O-M F-X",
                "19 W-U C-U Z-W I-W X-W M-W L-M Q-L F-C G-L H-G A-W J-Z R-I S-L T-M D-U Y-D M-R",
                "8 W-C O-W A-O I-O K-W Z-I G-I Y-G",
                "8 K-T H-K M-H Q-T F-M W-K Y-W D-Y",
                "6 D-R L-R M-L A-D V-R U-D"

                };
        List<String> paths = new ArrayList<>();
        String result = "";
        for (String task : data) {
            paths = Arrays.asList(task.split(" "));
//            paths.iterator().remove();
            String pathContains = "";
            boolean isLoop = false;
            for (int i = 1; i<paths.size();i++) {
                int count = 0;
                String[] cities = paths.get(i).split("-");
                if (!pathContains.contains(cities[0])) {
                    pathContains += cities[0];
                    count++;
                }
                if (!pathContains.contains(cities[1])) {
                    pathContains += cities[1];
                    count++;
                }
                if (count == 0) {
                    result += "1 ";
                    isLoop = true;
                    break;
                }
            }
            if (!isLoop) {
                result += "0 ";
            }
        }
        System.out.println(result);
    }
}
