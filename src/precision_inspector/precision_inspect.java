package precision_inspector;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import data.project;

public class precision_inspect {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/*
		 * 1. input.csv入力
		 * 2. ランダムに300個とってきてoutput.csvに出力
		 * 3. output.csvより対象のファイルとその行数出力
		 * 4. 正解なら〇，不正解なら×をつけ，そのcsvファイルの末尾に追加
		 * 5 .Bigclonebenchのフォルダからそのファイルを探してくる
		 *
		 *
		 */
		/*    System.out.println("入力してください。");

        Scanner sc1 = new Scanner(System.in);
        String line1 = sc1.nextLine();

        System.out.println("入力した文字は=" + line1);
		 */
		project project = new project();
		project.setInputfile(args[0]);
		project.setSubject_fol(args[1]);
		project.setResultfile(args[2]);
		project.setNum_of_random(300);

		//乱数生成
		ArrayList<Integer> random_num = gernerate_random_num(project);
		//行抽出
		generate_extrafile(random_num,project);
		output_code(project);









	}


	public static ArrayList<Integer> gernerate_random_num(project project) {
		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br_input = null;

		try {
			fi = new FileInputStream(project.getInputfile());
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		is = new InputStreamReader(fi);
		br_input = new BufferedReader(is);

		//読み込み行
		String lineA;
		int line_cnt =0;

		try {
			while ((lineA = br_input.readLine()) != null) {
				line_cnt++;
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		int clonepair_num = line_cnt;
		Random rand = new Random();
		ArrayList<Integer> random_num = new ArrayList<Integer>();
		int i=0;
		while(i<project.getNum_of_random()+1) {
			int num = rand.nextInt(clonepair_num + 1)+1;
			System.out.println(num);
			if(i == 0) {
				if(isMethod(num, project)) {
					random_num.add(num);
					i++;
				}
			}else {
				for(int j =0; j<random_num.size(); j++) {
					//System.out.println("j cout = " + j);
					if(num == random_num.get(j)) break;
					if(j == random_num.size()-1 && isMethod(num, project)) {
						random_num.add(num);
						i++;
						System.out.println("test");
					}
				}
			}
		}
		System.out.println("size = " + random_num.size());
		for(int k=0; k<random_num.size(); k++) {
			System.out.println("random_number = " + random_num.get(k));
		}

		Collections.sort(random_num);
		return random_num;

	}

	public static boolean isMethod(int num, project project) {
		//ランダムに抽出した行を出力


		try {
			String line;
			int line_cnt=0;
			int l =0;
			FileInputStream fi = null;
			InputStreamReader is = null;
			BufferedReader br_input = null;
			try {
				fi = new FileInputStream(project.getInputfile());
			} catch (FileNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			is = new InputStreamReader(fi);
			br_input = new BufferedReader(is);
			while ((line = br_input.readLine()) != null) {
				//	if(l==Def.num_of_random) break;
				if(num == line_cnt ) {
					String[] clone_data = line.split(",");
					String lineB;
					int lineB_cnt=0;
					FileInputStream fi2 = null;
					InputStreamReader is2 = null;
					BufferedReader br_input2 = null;
					try {
						fi2 = new FileInputStream(project.getSubject_fol() + "\\" + clone_data[0] + "\\" + clone_data[1]);
					} catch (FileNotFoundException e) {
						// TODO 自動生成された catch ブロック
						e.printStackTrace();
					}
					is2 = new InputStreamReader(fi2);
					br_input2 = new BufferedReader(is2);
					int method_flag =0;
					while ((lineB = br_input2.readLine()) != null) {
						if(lineB_cnt == Integer.parseInt(clone_data[2])-1) {
							System.out.println("code = " + lineB);
							if(lineB.contains(" void ") || lineB.contains("private ") || lineB.contains("public ") || lineB.contains(" static ")) {
								method_flag = 1;

								System.out.println("IS mthod");
								return true;
							}else {
								return false;
							}
						}

						lineB_cnt++;
					}
					l++;
				}
				line_cnt++;
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return false;

	}

	public static void generate_extrafile(ArrayList<Integer> random_num, project project) {
		//ランダムに抽出した行を出力


		FileWriter rf;
		try {
			rf = new FileWriter("random_file.txt");


			try {
				String lineB;
				int lineB_cnt=0;
				int l =0;
				FileInputStream fi2 = null;
				InputStreamReader is2 = null;
				BufferedReader br_input2 = null;
				try {
					fi2 = new FileInputStream(project.getInputfile());
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				is2 = new InputStreamReader(fi2);
				br_input2 = new BufferedReader(is2);
				while ((lineB = br_input2.readLine()) != null) {
					//	System.out.println("okoko = " + lineB);
					if(l==project.getNum_of_random()) break;
					if(random_num.get(l) == lineB_cnt ) {
						rf.write(lineB + "\r\n");
						l++;
					}
					lineB_cnt++;
				}
			} catch (IOException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			rf.close();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

	}

	public static void output_code(project project) {

		FileInputStream fi = null;
		InputStreamReader is = null;
		BufferedReader br_input = null;
		try {
			fi = new FileInputStream("random_file.txt");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		is = new InputStreamReader(fi);
		br_input = new BufferedReader(is);
		String line;
		try {
			int line_cnt =1;
			while ((line = br_input.readLine()) != null) {
				FileWriter result = new FileWriter(project.getResultfile(), true);
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("");
				System.out.println("random_file = " + line);
				String[] clone_data = line.split(",");
				String line1;
				String line2;
				int line1_cnt=0;
				int line2_cnt=0;
				int l =0;
				FileInputStream fi1 = null;
				InputStreamReader is1 = null;
				BufferedReader br_input1 = null;
				FileInputStream fi2 = null;
				InputStreamReader is2 = null;
				BufferedReader br_input2 = null;
				try {
					fi1 = new FileInputStream(project.getSubject_fol() + "\\" + clone_data[0] + "\\" + clone_data[1]);
					fi2 = new FileInputStream(project.getSubject_fol() + "\\" + clone_data[4] + "\\" + clone_data[5]);
				} catch (FileNotFoundException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				is1 = new InputStreamReader(fi1);
				br_input1 = new BufferedReader(is1);
				int cnt = 1;
				while ((line1 = br_input1.readLine()) != null) {
					if((line1_cnt >= Integer.parseInt(clone_data[2])-1) && (line1_cnt <= Integer.parseInt(clone_data[3])-1)) {
						System.out.println(cnt + " : " + line1);
						cnt++;
					}

					line1_cnt++;
				}



				System.out.println("===============================================================");
				System.out.println("===============================================================");

				is2 = new InputStreamReader(fi2);
				br_input2 = new BufferedReader(is2);
				int cnt2=1;
				while ((line2 = br_input2.readLine()) != null) {
					if((line2_cnt >= Integer.parseInt(clone_data[6])-1) && (line2_cnt <= Integer.parseInt(clone_data[7])-1)) {
						System.out.println(cnt2  + " : " + line2);
						cnt2++;
					}

					line2_cnt++;


				}


				int j =0;

				while(j<100) {
					System.out.println("");
					System.out.println("No. " + line_cnt);
					System.out.println("");
					System.out.println("Please input y or n");
					Scanner sc1 = new Scanner(System.in);
					String input_line = sc1.nextLine();
					System.out.println("Your input is " + input_line);
					if(input_line.equals("y") || input_line.equals("n") )  {
						result.write(line + "," + input_line + "\r\n");
						result.close();
						break;
					}
					System.out.println("Input correctly");

					j++;
				}
				line_cnt++;


			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}

}


