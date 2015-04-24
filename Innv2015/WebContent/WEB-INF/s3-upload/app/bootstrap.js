(function($) {

    $(document).ready(function() {

	window.defaultMyImage =
	    new MyImage({filename: 'preview.png',
			 data: 'img/preview.png',
			 bucket: 'itsa-web-rds',
			 acl: 'public-read',
			 successActionRedirect: 'http://localhost:8080/innov2015',
			 contentType: 'image/',
			 folder: 'spike/',
			 AWSAccessKeyId: 'AKIAISKJJA6KIJTJLM5Q',
			 AWSSecretKeyId: '818FPYUkQGvnOuOri/gYnl+eAaz2JVkl3S5mh/5F'
			});

	window.imagePreviewView =
	    new ImagePreviewView({model: window.defaultMyImage});
	window.imageFileView =
	    new ImageFileView({model: window.defaultMyImage});

	window.App = new window.ImageRouter();
	Backbone.history.start();
    });

})(jQuery);
