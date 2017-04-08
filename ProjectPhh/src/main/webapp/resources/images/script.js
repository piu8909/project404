;(function($) {

	var Area = {};

	Area.Comment = (function() {
		var $btnOpen = $(".btn_reply"),
			$fieldReply = $(".fld_reply");

		var changeStatus = function() {
			$btnOpen.toggleClass("on");
		};

		var init = function() {
			if ($fieldReply.is(":visible")) {
				$btnOpen.addClass("on");
			}
		};

		return {
			init: init,
			changeStatus: changeStatus
		}
	})();

	Area.SocialShare = (function() {

		var SOCIAL_SHARE = {
			kakaostory: {
				url: "https://story.kakao.com/share",
				width: 640,
				height: 400,
				makeShareUrl: function(url) {
					return this.url + "?url=" + encodeURIComponent(url);
				}
			},
			facebook: {
				url: "https://www.facebook.com/sharer/sharer.php",
				width: 640,
				height: 400,
				makeShareUrl: function(url) {
					return this.url + "?display=popup&u=" + encodeURIComponent(url);
				}
			},
			twitter: {
				url: "https://twitter.com/intent/tweet",
				width: 640,
				height: 400,
				makeShareUrl: function(url) {
					return this.url + "?url=" + encodeURIComponent(url);
				}
			}
		};


		var onClick = function(e) {
			var $this = $(this),
				service = SOCIAL_SHARE[$this.data("service")],
				url = location.href;

			if (service) {
				e.preventDefault();
				window.open(service.makeShareUrl(url), "", "width=" + service.width + ", height=" + service.height);
			}
		};


		var init = function() {
			$(".list_share").on("click", "a", onClick);
		};

		return {
			init: init
		}
	})();

	Area.init = function() {
		Area.Comment.init();
		Area.SocialShare.init();
	};

	$.Area = Area;

})(jQuery);

function tgo(id){
	$("#"+id).toggleClass("dno");
}

$(document).ready(
	function(){
		var $container=$('#lst_gal');

		if($("#lst_gal .list_content .thumb").length > 0){
			$container.imagesLoaded(
				function(){
					$container.masonry({
						itemSelector:'.list_content',
						isAnimated:true});
			});
		}

		$(".tab_line ul li a").mouseenter(function(){
			$(this).parent().find("ul").show();
			var pl = $(this).parent().position().left;
			$(this).parent().find("ul").css("left",pl);
		}).mouseleave(function(){
			$(this).parent().find("ul").hide();
		});

		$(".tab_line ul li ul li ul").mouseenter(function(){
			$(this).show();
		}).mouseleave(function(){
			$(this).hide();
		});

		var $all = $(".tab_line ul li a").eq(0);
		if($all.length > 0){
			$all.parent().find("ul").eq(0).prepend('<li class="on"><a href="/category">'+$all.html()+'</a></li>');
			$all.remove();
		}

		var res_tab = $(".res_tab");
		$(".tab_line a").each(function(i){
			var name = $(this).text();
			var href = $(this).attr("href");
			
			res_tab.append($("<option></option>").attr("value",href).text(name));
		});
	}
);