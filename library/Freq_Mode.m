[num] = textread('wordFreqBigwithModeonly_Skipgram');
num = log(num+1);
[r,p] = corrcoef(num);
scatter(num(:,1),num(:,2),'r.')
xlabel('log(��Ƶ)')
ylabel('log(��������ģ��)')
title('�����ݼ���log(��Ƶ)��log(������ģ��)�Ĺ�ϵ')
box on
saveas(gcf,'M-vectorBig.png')