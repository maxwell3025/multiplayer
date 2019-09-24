package BinaryInteractions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileOutput {

	static byte[] tobytes(int i) {
		double totalleft = i;
		byte[] result = new byte[4];
		result[0] = (byte) ((int) Math.floor(totalleft / 16777216));
		totalleft = totalleft - Math.floor(totalleft / 16777216) * 16777216;
		result[1] = (byte) ((int) Math.floor(totalleft / 65536));
		totalleft = totalleft - Math.floor(totalleft / 65536) * 65536;
		result[2] = (byte) ((int) Math.floor(totalleft / 256));
		totalleft = totalleft - Math.floor(totalleft / 256) * 256;
		result[3] = (byte) ((int) Math.floor(totalleft));
		return result;

	}

	public static void writeints(int[] a, String url) throws IOException {
			List<Byte> b = new ArrayList<Byte>();
			for (int i = 0; i < a.length; i++) {
				b.add(tobytes(a[i])[0]);
				b.add(tobytes(a[i])[1]);
				b.add(tobytes(a[i])[2]);
				b.add(tobytes(a[i])[3]);
			}
			FileOutputStream output = new FileOutputStream(url);
			byte[] c = new byte[b.size()];
			for (int index = 0; index < b.size(); index++) {
				c[index] = b.get(index);
			}
			output.write(c);
			output.close();
	}

	public static void main(String[] args) throws IOException {
		int[] nums = { 12,523,15,1,647,2,32768,7473,838,3,7,4,76,3,654,5,47,4,0,68,85, };
		String url = new String("W:/multiplayer/testcrap.this_filename_is_really__really_long__like_ridiculously_long__i_bet_you_can_t_even_see_the_whole_name_on_your_screen__even_on_two_screens__also__what_s_your_favourite_flavor_of_ice_cream__mine_s_chocolate__also__did_you_know_martin_luther_king_jr__was_born_in_the_same_year_as_anne_frank__crazy_right__furthermore__want_to_know_the_history_of_austrailia__well_go_on_ebay_and_buy_a_book_about_it__also_take_out_that_low_interest_loan__it_s_worth_it__an_interesting_factoid_is_that_coffee_can_cause_face_cancer__just_kidding__but_imagine_it_did__and_we_never_knew__that_would_be_scary_wouldn_t_it_");
		writeints(nums, url);
	}

}
