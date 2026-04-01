document.getElementById('loginForm').addEventListener('submit', function(e) {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    const message = document.getElementById('message');
    
    if (username && password) {
        message.textContent = `欢迎 ${username}！登录成功`;
        message.style.color = '#28a745';
    } else {
        message.textContent = '请填写用户名和密码';
        message.style.color = '#dc3545';
    }
});