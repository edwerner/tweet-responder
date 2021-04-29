$(document).ready(function(){
	$(".activate-button").click(function() {
		$(".home").hide();
		$(".tweet-content").show();
	});
	$(".home-button").click(function() {
		$(".tweet-content").hide();
		$(".home").show();
	});
});