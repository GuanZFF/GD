$(function() {
		/* 导航栏搜索设置 */
		$('#liSearch,#btnSearch').on('click', function () {
			console.log('jjjj');
			if($('#search').hasClass('glyphicon-search')){
				$('#search-open').slideDown(500);
                $('#search').removeClass('glyphicon-search');
                $('#search').addClass('glyphicon-remove');
			} else {
				$('#search-open').slideUp(500);
                $('#search').addClass('glyphicon-search');
                $('#search').removeClass('glyphicon-remove');
			}
		});
		$('#btnSearch').on('click', function() {
			var name = $('#inputSearch').val();
			$.ajax({
				data: {produceName: name},
				dataType: 'json',
				type: 'post',
				url: '/PC/getproduceinfobyname',
				success: function(result) {
					if (result != null && result != '' && result.produceId != null && result.produceId != '') {
						location.href = '/pages/common/produceDetail.html?produceId=' + result.produceId;
					} else {
						layer.msg('此数据不存在');
					}
				}
			})
		});
		/* 导航栏搜索设置 */
		/* ------------------------根部设置------------------------ */
		$.ajax({
			url : "/usercontroller/getuserdetail",
			type : "get",
			dataType : "json",
			success : function(result) {
				$('#userImg').attr('src', result.userImg);
				$('#userImage').prop('src', result.userImg);
				$('#usernameh').html(result.userName);
			}
		});
		$('#aboutMe').on('click', function() {
			layer.msg('我们是一个关于电子商务的推荐系统，部分功能静候期待');
		});
		$('#recentMessage').on('click', function() {
			$.ajax({
				url: '/sysdictcontroller/listsysdictbytype',
				data: {sysDictType: 'message'},
				dataType: 'json',
				type: 'post',
				success: function(result) {
					if (result.length == 0) {
						layer.msg('暂无消息信息！！！', {time: 700});
					} else {
						var message = ''
						for (var i = 0; i < result.length; i++) {
							message = message + result[i].sysDictName + ';';
						}
						layer.msg(message);
					}
				}
			})
		});
		$('#userImg').on('mouseover', function() {
			if ($('#username').css('display') == 'none') {
				$('#username').fadeIn(500);
				setTimeout(function() {
					$('#username').fadeOut(500);
				}, 2000);
			}
		});
		/* ------------------------根部设置------------------------ */
	});