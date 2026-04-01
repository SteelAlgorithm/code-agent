document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('loginForm');
    const message = document.getElementById('message');
    
    form.addEventListener('submit', function(event) {
        event.preventDefault();
        
        const username = document.getElementById('username').value.trim();
        const password = document.getElementById('password').value.trim();
        
        // 简单的验证逻辑
        if (username === '' || password === '') {
            showMessage('请填写用户名和密码', 'error');
            return;
        }
        
        // 模拟登录成功
        showMessage('登录成功！正在跳转...', 'success');
        
        // 清空表单
        form.reset();
    });
    
    function showMessage(text, type) {
        message.textContent = text;
        message.style.color = type === 'error' ? '#dc3545' : '#28a745';
        
        // 3秒后清空消息
        setTimeout(() => {
            message.textContent = '';
        }, 3000);
    }
});