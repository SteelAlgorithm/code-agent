document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');
    
    // 简单的验证逻辑
    if(username && password) {
        message.textContent = '登录成功！';
        message.style.backgroundColor = '#d4edda';
        message.style.color = '#155724';
        message.style.display = 'block';
        
        // 模拟登录成功后的操作
        setTimeout(() => {
            message.textContent = '正在跳转...';
        }, 1000);
    } else {
        message.textContent = '请填写用户名和密码';
        message.style.backgroundColor = '#f8d7da';
        message.style.color = '#721c24';
        message.style.display = 'block';
    }
});