[num] = textread('wordFreqSmallonly');
inteval = [1];
k = 1;
while (k < max(num))
    k = k + ceil(k/100);
    inteval = [inteval, k];
end
split = length(inteval)-1;
point = [];
for i=1:split
    point(i) = (inteval(i)+inteval(i+1))/2;
end
[K] = histc(num, inteval);
plot(log(point'),log(K(1:split,1)+1),'r')
xlabel('log(��Ƶ��С)/��')
ylabel('log(�ʵĸ���)')
title('�����ݼ���log(�ʵĸ���)��log(��Ƶ��С)�Ĺ�ϵ')
box on
% saveas(gcf,'log-logBig.png')
figure
plot(log(point'),K(1:split,1),'r')
xlabel('log(��Ƶ��С)/��')
ylabel('�ʵĸ���')
title('�����ݼ��´ʵĸ�����log(��Ƶ��С)�Ĺ�ϵ')
box on
% saveas(gcf,'log-1Big.png')