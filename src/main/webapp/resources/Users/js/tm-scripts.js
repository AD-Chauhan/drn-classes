// Smooth scroll blocking
document.addEventListener( 'DOMContentLoaded', function() {
	if ( 'onwheel' in document ) {
		window.onwheel = function( event ) {
			if( typeof( this.RDSmoothScroll ) !== undefined ) {
				try { window.removeEventListener( 'DOMMouseScroll', this.RDSmoothScroll.prototype.onWheel ); } catch( error ) {}
				event.stopPropagation();
			}
		};
	} else if ( 'onmousewheel' in document ) {
		window.onmousewheel= function( event ) {
			if( typeof( this.RDSmoothScroll ) !== undefined ) {
				try { window.removeEventListener( 'onmousewheel', this.RDSmoothScroll.prototype.onWheel ); } catch( error ) {}
				event.stopPropagation();
			}
		};
	}

	try { $('body').unmousewheel(); } catch( error ) {}
});
function include(scriptUrl) {
    document.write('<script src="' + scriptUrl + '"></script>');
}

function isIE() {
    var myNav = navigator.userAgent.toLowerCase();
    return (myNav.indexOf('msie') != -1) ? parseInt(myNav.split('msie')[1]) : false;
};

/* cookie.JS
 ========================================================*/
include('/online-classrooms/resources/Users/js/jquery.cookie.js');

/* Easing library
 ========================================================*/
include('/online-classrooms/resources/Users/js/jquery.easing.1.3.js');


/* Stick up menus
 ========================================================*/
;
(function ($) {
    var o = $('html');
    if (o.hasClass('desktop')) {
        include('/online-classrooms/resources/Users/js/tmstickup.js');

        $(document).ready(function () {
            $('#stuck_container').TMStickUp({})
        });
    }
})(jQuery);

/* ToTop
 ========================================================*/
;
(function ($) {
    var o = $('html');
    if (o.hasClass('desktop')) {
        include('/online-classrooms/resources/Users/js/jquery.ui.totop.js');

        $(document).ready(function () {
            $().UItoTop({easingType: 'easeOutQuart'});
        });
    }
})(jQuery);

/* EqualHeights
 ========================================================*/
;
(function ($) {
    var o = $('[data-equal-group]');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/jquery.equalheights.js');
    }
})(jQuery);

/* SMOOTH SCROLLIG
 ========================================================*/
;
(function ($) {
    var o = $('html');
    if (o.hasClass('desktop')) {
        include('/online-classrooms/resources/Users/js/jquery.mousewheel.min.js');
        include('/online-classrooms/resources/Users/js/jquery.simplr.smoothscroll.min.js');

        $(document).ready(function () {
            $.srSmoothscroll({
                step: 150,
                speed: 800
            });
        });
    }
})(jQuery);

/* Copyright Year
 ========================================================*/
;
(function ($) {
    var currentYear = (new Date).getFullYear();
    $(document).ready(function () {
        $("#copyright-year").text((new Date).getFullYear());
    });
})(jQuery);


/* Superfish menus
 ========================================================*/
// include('superfish.js');
// jQuery(function () {
// 	jQuery('.sf-menu').mobileMenu();
// })

;
(function ($) {
    function include(url) {
	document.write('<script src="/online-classrooms/resources/Users/js/' + url + '"></script>');
	return false;
}
	include('superfish.js');
	jQuery(function () {
	// jQuery('.sf-menu').mobileMenu();
})
	// include('jquery.mobilemenu.js');
})(jQuery);

/* Mobilemenu
========================================================*/


/* Navbar
 ========================================================*/
;
(function ($) {
    include('/online-classrooms/resources/Users/js/jquery.rd-navbar.js');
})(jQuery);


/* Google Map
 ========================================================*/
;
(function ($) {
    var o = document.getElementById("google-map");
    if (o) {
        include('https://maps.google.com/maps/api/js?sensor=false');
        include('/online-classrooms/resources/Users/js/jquery.rd-google-map.js');

        $(document).ready(function () {
            var o = $('#google-map');
            if (o.length > 0) {
                o.googleMap();
            }
        });
    }
})
(jQuery);

/* Owl Carousel
========================================================*/
;(function ($) {
    var o = $('.owl-carousel');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/owl.carousel.min.js');
        $(document).ready(function () {
            o.owlCarousel({
                margin: 30,
                smartSpeed: 450,
                loop: true,
                dots: false,
                dotsEach: 1,
                nav: true,
                navClass: ['owl-prev fa fa-angle-left', 'owl-next fa fa-angle-right'],
                responsive: {
                    0: { items: 1 },
                    768: { items: 1},
                    980: { items: 1}
                }
            });
        });
    }
})(jQuery);


/* WOW
 ========================================================*/
;
(function ($) {
    var o = $('html');

    if ((navigator.userAgent.toLowerCase().indexOf('msie') == -1 ) || (isIE() && isIE() > 9)) {
        if (o.hasClass('desktop')) {
            include('/online-classrooms/resources/Users/js/wow.js');

            $(document).ready(function () {
                new WOW().init();
            });
        }
    }
})(jQuery);

/* Contact Form
 ========================================================*/
;
(function ($) {
    var o = $('#contact-form');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/modal.js');
        include('/online-classrooms/resources/Users/js/TMForm.js'); 

        if($('#contact-form .recaptcha').length > 0){
        	include('//www.google.com/recaptcha/api//online-classrooms/resources/Users/js/recaptcha_ajax.js');
        }
    }
})(jQuery);

/* Orientation tablet fix
 ========================================================*/
$(function () {
    // IPad/IPhone
    var viewportmeta = document.querySelector && document.querySelector('meta[name="viewport"]'),
        ua = navigator.userAgent,

        gestureStart = function () {
            viewportmeta.content = "width=device-width, minimum-scale=0.25, maximum-scale=1.6, initial-scale=1.0";
        },

        scaleFix = function () {
            if (viewportmeta && /iPhone|iPad/.test(ua) && !/Opera Mini/.test(ua)) {
                viewportmeta.content = "width=device-width, minimum-scale=1.0, maximum-scale=1.0";
                document.addEventListener("gesturestart", gestureStart, false);
            }
        };

    scaleFix();
    // Menu Android
    if (window.orientation != undefined) {
        var regM = /ipod|ipad|iphone/gi,
            result = ua.match(regM);
        if (!result) {
            $('.sf-menus li').each(function () {
                if ($(">ul", this)[0]) {
                    $(">a", this).toggle(
                        function () {
                            return false;
                        },
                        function () {
                            window.location.href = $(this).attr("href");
                        }
                    );
                }
            })
        }
    }
});
var ua = navigator.userAgent.toLocaleLowerCase(),
    regV = /ipod|ipad|iphone/gi,
    result = ua.match(regV),
    userScale = "";
if (!result) {
    userScale = ",user-scalable=0"
}
document.write('<meta name="viewport" content="width=device-width,initial-scale=1.0' + userScale + '">');

/* Camera
========================================================*/
;(function ($) {
var o = $('#camera');
    if (o.length > 0) {
        if (!(isIE() && (isIE() > 9))) {
            include('/online-classrooms/resources/Users/js/jquery.mobile.customized.min.js');
        }

        include('/online-classrooms/resources/Users/js/camera.js');

        $(document).ready(function () {
            o.camera({
                autoAdvance: true,
                height: '46.58536585365854%',
                minHeight: '955px',
                pagination: true,
                thumbnails: false,
                playPause: false,
                hover: false,
                loader: 'none',
                navigation: false,
                navigationHover: false,
                mobileNavHover: false,
                fx: 'simpleFade'
            })
        });
    }
})(jQuery);

/* Search.js
 ========================================================*/
;
(function ($) {
    var o = $('.search-form');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/TMSearch.js');
    }
})(jQuery);  

/* Booking Form
 ========================================================*/
;
(function ($) {
    var o = $('#bookingForm');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/booking/booking.js');
        include('/online-classrooms/resources/Users/js/booking/jquery-ui-1.10.3.custom.min.js');
        include('/online-classrooms/resources/Users/js/booking/jquery.fancyform.js');
        include('/online-classrooms/resources/Users/js/booking/jquery.placeholder.js');
        include('/online-classrooms/resources/Users/js/booking/regula.js');
        $(document).ready(function () {
            o.bookingForm({
                ownerEmail: '#'
            });
        });
    }
})(jQuery);

/* Subscribe Form
 ========================================================*/
;
(function ($) {
    var o = $('#subscribe-form');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/sForm.js');
    }
})(jQuery);




/* panel */
include('/online-classrooms/resources/Users/js/jquery.cookie.js');

$(document).ready(function () {
	$('head').append('<link rel="stylesheet" href="/online-classrooms/resources/Users/assets/tm/css/tm_docs.css" type="text/css" media="screen">');
	});
$(window).scroll(
	function () {
		if (
			$(this).scrollTop() > 0) {
			$("#advanced").css({
				position: 'fixed'
			});
		} else {
			$("#advanced").css({
				position: 'relative'
			});
		}
	}
);
$(function () {
	var
		strCookies1 = $.cookie('panel1'),
		isAnimate = false,
		isOpen = false;

	if (strCookies1 == null) {
		$.cookie('panel1', 'closed');
		strCookies1 = $.cookie('panel1');
		isOpen = false;
	}

	if (strCookies1 == 'opened') {
		$("#advanced").css({
			marginTop: '0px'
		}).removeClass('closed');
		isOpen = true;
		$('#stuck_container').trigger('rePosition', 50); //for sticky menu
	} else {
		$("#advanced").css({
			marginTop: '-50px'
		}).addClass('closed');
		isOpen = false;
		$('#stuck_container').trigger('rePosition', 0); //for sticky menu
	}

	$("#advanced .trigger").click(
		function () {
			if (!isOpen) {
				$(this).find('strong').animate({
					opacity: 0
				}).parent().parent('#advanced').removeClass('closed').animate({
					marginTop: '0px'
				}, 300);
				$.cookie('panel1', 'opened');
				strCookies1 = $.cookie('panel1');

				isOpen = true;
				$('#stuck_container').trigger('rePosition', 50);
			} else {
				$(this).find('strong').animate({
					opacity: 1
				}).parent().parent('#advanced').addClass('closed').animate({
					marginTop: '-50px'
				}, 300)
				$.cookie('panel1', 'closed');
				strCookies1 = $.cookie('panel1');

				isOpen = false;
				$('#stuck_container').trigger('rePosition', 0); //for sticky menu
			}
		}
	)
});
/*--------- end panel *------------*/

/* Facebook
 ========================================================*/


/* Responsive Tabs
 ========================================================*/
;
(function ($) {
    var o = $('.resp-tabs');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/jquery.responsive.tabs.js');

        $(document).ready(function () {
            o.easyResponsiveTabs();
        });
    }
})(jQuery);


/* FancyBox
========================================================*/
;(function ($) {
    var o = $('.thumb');
    if (o.length > 0) {
        include('/online-classrooms/resources/Users/js/jquery.fancybox.js');
        include('/online-classrooms/resources/Users/js/jquery.fancybox-media.js');
        include('/online-classrooms/resources/Users/js/jquery.fancybox-buttons.js');
        $(document).ready(function () {
            o.fancybox();
        });
    }
})(jQuery);

/* Parallax
=============================================*/
;(function ($) {
    include('/online-classrooms/resources/Users/js/jquery.rd-parallax.js');
})(jQuery); 



