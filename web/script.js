$(document).ready(function(){
	
	var znak_user = 'O';
	var znak_comp = 'X';
	
	var rand_num = Math.round((Math.random() * (9 - 1) + 1));
	
	if( rand_num > 3 ){
		var znak_comp = 'O';
		var znak_user = 'X';
		$('.cell'+rand_num).text(znak_comp);
	}
	
	var exit_flag = false;
	var win_user_array = ['123','456','789','147','258','369','159','357'];
		
	function check_3_user(znak){
		for (var i = 0; i < 8; i++) {
		
			var first = 'cell' + win_user_array[i].substr(0,1);
			var second = 'cell' + win_user_array[i].substr(1,1);
			var third = 'cell' + win_user_array[i].substr(2,1);
			
			if( $('.'+first).text() == znak && $('.'+second).text() == znak && $('.'+third).text() == znak ){
				$('.'+first+',.'+second+',.'+third).css("background-color", "#83e2c3");
				$('.result').text('You won!').css("text-align", "center");
				$('.krestiki_noliki .block').unbind('click');
				var findlink = document.getElementById("first");
                findlink.href = "http://localhost:8080/GameServlet?victory=true";
				exit_flag = true;
			}	
		}
	}
	
	function check_2_comp(znak){
		for (var i = 0; i < 8; i++) {
		
			var first = 'cell' + win_user_array[i].substr(0,1);
			var second = 'cell' + win_user_array[i].substr(1,1);
			var third = 'cell' + win_user_array[i].substr(2,1);
			
			if( $('.'+first).text() == znak && $('.'+second).text() == znak && $('.'+third).text() == '' ){
				$('.'+third).text(znak);
				$('.'+first+',.'+second+',.'+third).css("background-color", "#EF7C7C");
				$('.result').text('You lost!').css("text-align", "center");
				$('.krestiki_noliki .block').unbind('click');
                var findlink = document.getElementById("first");
                findlink.href = "http://localhost:8080/GameServlet?victory=false";
				exit_flag = true;
			}	
			
			if( $('.'+first).text() == znak && $('.'+second).text() == '' && $('.'+third).text() == znak ){
				$('.'+second).text(znak);
				$('.'+first+',.'+second+',.'+third).css("background-color", "#EF7C7C");
				$('.result').text('You lost!').css("text-align", "center");
				$('.krestiki_noliki .block').unbind('click');
                var findlink = document.getElementById("first");
                findlink.href = "http://localhost:8080/GameServlet?victory=flase";
				exit_flag = true;
			}	
			
			if( $('.'+first).text() == '' && $('.'+second).text() == znak && $('.'+third).text() == znak ){
				$('.'+first).text(znak);
				$('.'+first+',.'+second+',.'+third).css("background-color", "#EF7C7C");
				$('.result').text('You lost!').css("text-align", "center");
				$('.krestiki_noliki .block').unbind('click');
                var findlink = document.getElementById("first");
                findlink.href = "http://localhost:8080/GameServlet?victory=false";
				exit_flag = true;
			}	
		}
	}
	
	function check_2_user(znak){

		for (var i = 0; i < 8; i++) {
		
			var first = 'cell' + win_user_array[i].substr(0,1);
			var second = 'cell' + win_user_array[i].substr(1,1);
			var third = 'cell' + win_user_array[i].substr(2,1);

			
			if( exit_flag == false ){
				if( $('.'+first).text() == znak && $('.'+second).text() == znak && $('.'+third).text() == '' ){
					$('.'+third).text(znak_comp);
					exit_flag = true;
				}
			}
						
			if( exit_flag == false ){
				if( $('.'+first).text() == znak && $('.'+second).text() == '' && $('.'+third).text() == znak ){
					$('.'+second).text(znak_comp);
					exit_flag = true;
				}	
			}	
			
			if( $('.'+first).text() == '' && $('.'+second).text() == znak && $('.'+third).text() == znak ){
				$('.'+first).text(znak_comp);
				exit_flag = true;
			}
			
			if(exit_flag) break;
		}
	}
	
	$('.krestiki_noliki .block').click(function(){

		if( $(this).text() == '' ){
			$(this).text(znak_user);	
			check_3_user(znak_user);
			check_2_comp(znak_comp);
			check_2_user(znak_user);
			
			if( exit_flag == false ){
				for (var i = 1; i < 10; i++) {	
					if( $('.cell'+i).text() == '' ){
						$('.cell'+i).text(znak_comp);
						break;
					}	
				}
			}else exit_flag = false;
			

		}
	});
});